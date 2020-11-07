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
    public static final int TEAMS_PER_ALLOCATION = 6;

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

    private List<Team> getShuffledGroups() {
        List<Student> allStudents = studentService.findAllStudents(Optional.empty());
        Collections.shuffle(allStudents);
        List<Team> teams = IntStream.rangeClosed(1, TEAMS_PER_ALLOCATION)
                .mapToObj(index -> new Team(String.valueOf(index), "Team " + index, new ArrayList<>()))
                .collect(Collectors.toList());
        int curGroupIndex = 0;
        for (Student student : allStudents) {
            teams.get(curGroupIndex).getStudents().add(student);
            curGroupIndex
                    = curGroupIndex == TEAMS_PER_ALLOCATION - 1
                    ? 0
                    : curGroupIndex + 1;
        }
        return teams;
    }
}
