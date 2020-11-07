package com.thoughtworks.capability.gtb.restfulapidesign.model;

import java.util.List;

public class Allocation {
    private String id;
    private List<Group> groups;

    public Allocation() {
    }

    public Allocation(String id, List<Group> groups) {
        this.id = id;
        this.groups = groups;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
