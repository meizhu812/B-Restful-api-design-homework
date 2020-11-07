package com.thoughtworks.capability.gtb.restfulapidesign.model;

import java.util.List;

public class Team {
    private String id;
    private String name;
    private List<Student> students;

    public Team() {
    }

    public Team(String id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
