package com.thoughtworks.capability.gtb.restfulapidesign.model;

import java.util.List;

public class Group {
    private String id;
    private String name;
    private String gender;
    private List<Student> students;

    public Group() {
    }

    public Group(String id, String name, String gender, List<Student> students) {
        this.id = id;
        this.name = name;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
