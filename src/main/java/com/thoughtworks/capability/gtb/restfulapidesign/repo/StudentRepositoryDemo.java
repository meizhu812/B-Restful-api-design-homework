package com.thoughtworks.capability.gtb.restfulapidesign.repo;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StudentRepositoryDemo implements StudentRepository {
    private final Map<String, Student> students = new TreeMap<>();
    private static final int MAX_STUDENTS = 5;
    private int currentIdNo = 0;

    public StudentRepositoryDemo() {
    }

    @Override
    public Optional<Student> save(Student student) {
        if (student.getId() == null) {
            if (currentIdNo == MAX_STUDENTS) {
                return Optional.empty();
            }
            currentIdNo++;
            student.setId(String.valueOf(currentIdNo));
            students.put(student.getId(), student);
            return Optional.of(student);
        }
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return Optional.of(student);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Student> deleteById(String id) {
        return Optional.ofNullable(students.remove(id));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public Optional<Student> findById(String id) {
        return Optional.ofNullable(students.getOrDefault(id, null));
    }
}
