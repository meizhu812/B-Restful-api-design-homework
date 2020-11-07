package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Allocation;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repo.AllocationRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class AllocationService {
    private final StudentService studentService;
    private final AllocationRepository allocationRepository;
    public static final int TEAMS_COUNT = 6;

    public AllocationService(StudentService studentService, AllocationRepository allocationRepository) {
        this.studentService = studentService;
        this.allocationRepository = allocationRepository;
    }

    public Optional<Allocation> createAllocation() {
        List<Team> teams = getShuffledGroups();
        Allocation newAllocation = new Allocation(null, teams);
        return allocationRepository.save(newAllocation);
    }

    public Optional<Allocation> getLatestAllocation() {
        return allocationRepository.findLatest();
    }

    public Optional<Allocation> updateTeamNameOfLatest(String teamId, String newName) {
        Optional<Allocation> optionalAllocation = allocationRepository.findLatest();
        if (!optionalAllocation.isPresent()) {
            return Optional.empty();
        }
        Allocation allocation = optionalAllocation.get();
        try {
            Team team = allocation.getGroups().get(Integer.parseInt(teamId) - 1);
            team.setName(newName);
            return Optional.of(allocation);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private List<Team> getShuffledGroups() {
        List<Student> allStudents = studentService.findAllStudents(Optional.empty());
        Collections.shuffle(allStudents);
        List<Team> teams = IntStream.rangeClosed(1, TEAMS_COUNT)
                .mapToObj(index -> new Team(String.valueOf(index), "Team " + index, new ArrayList<>()))
                .collect(Collectors.toList());
        int curTeamIndex = 0;
        for (Student student : allStudents) {
            teams.get(curTeamIndex).getStudents().add(student);
            curTeamIndex
                    = curTeamIndex == TEAMS_COUNT - 1
                    ? 0
                    : curTeamIndex + 1;
        }
        teams.forEach(team -> team.getStudents().sort(Comparator.comparing(Student::getId)));
        return teams;
    }
}
