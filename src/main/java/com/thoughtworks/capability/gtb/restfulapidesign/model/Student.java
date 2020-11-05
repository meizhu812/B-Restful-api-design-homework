package com.thoughtworks.capability.gtb.restfulapidesign.model;

public class Student {
    private String id;
    private String name;
    private String gender;
    private String note;

    public Student() {
    }

    public Student(String id, String name, String gender, String note) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.note = note;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
