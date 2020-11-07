package com.thoughtworks.capability.gtb.restfulapidesign.model;

import java.util.List;

public class Allocation {
    private String id;
    private List<Team> teams;

    public Allocation() {
    }

    public Allocation(String id, List<Team> teams) {
        this.id = id;
        this.teams = teams;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Team> getGroups() {
        return teams;
    }

    public void setGroups(List<Team> teams) {
        this.teams = teams;
    }
}
