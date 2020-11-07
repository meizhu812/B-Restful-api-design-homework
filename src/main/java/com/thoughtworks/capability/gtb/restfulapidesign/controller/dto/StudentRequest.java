package com.thoughtworks.capability.gtb.restfulapidesign.controller.dto;

public class StudentRequest {
    private String name;
    private String gender;
    private String note;

    public StudentRequest() {
    }

    public StudentRequest(String name, String gender, String note) {
        this.name = name;
        this.gender = gender;
        this.note = note;
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
