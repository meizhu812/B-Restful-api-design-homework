package com.thoughtworks.capability.gtb.restfulapidesign.controller.dto;

public class ChangeTeamNameRequest {
    private String name;

    public ChangeTeamNameRequest() {
    }

    public ChangeTeamNameRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
