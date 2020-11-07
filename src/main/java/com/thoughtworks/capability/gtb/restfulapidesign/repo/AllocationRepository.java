package com.thoughtworks.capability.gtb.restfulapidesign.repo;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Allocation;

import java.util.Optional;

public interface AllocationRepository {
    Optional<Allocation> save(Allocation allocation);

    Optional<Allocation> findLatest();
}
