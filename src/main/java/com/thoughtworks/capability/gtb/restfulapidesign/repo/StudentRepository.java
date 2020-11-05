package com.thoughtworks.capability.gtb.restfulapidesign.repo;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;

import java.util.Optional;

public interface StudentRepository {
    Optional<Student> save(Student student);

    Optional<Student> deleteById(String id);
}
