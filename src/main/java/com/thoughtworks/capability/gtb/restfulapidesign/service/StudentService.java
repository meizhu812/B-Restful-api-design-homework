package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.controller.dto.AddStudentRequest;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepo;

    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Optional<Student> addStudentFromRequest(AddStudentRequest request) {
        return studentRepo.save(new Student(null, request.getName(), request.getGender(), request.getNote()));
    }

    public boolean deleteStudentById(String id) {
        return studentRepo.deleteById(id).isPresent();
    }


    public List<Student> findAllStudents(Optional<String> genderFilter) {
        List<Student> allStudents = studentRepo.findAll();
        return genderFilter.map(
                gender -> allStudents.stream()
                        .filter(student -> student.getGender().equals(gender))
                        .collect(Collectors.toList()))
                .orElse(allStudents);
    }
}
