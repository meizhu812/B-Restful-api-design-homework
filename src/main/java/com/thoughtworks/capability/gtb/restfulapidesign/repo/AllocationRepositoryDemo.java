package com.thoughtworks.capability.gtb.restfulapidesign.repo;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Allocation;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AllocationRepositoryDemo implements AllocationRepository {
    private final List<Allocation> allocations = new ArrayList<>();
    private static final int MAX_ALLOCATIONS = 5;

    @Override
    public Optional<Allocation> save(Allocation allocation) {
        if (allocations.size() == MAX_ALLOCATIONS) {
            return Optional.empty();
        }
        allocation.setId(String.valueOf(allocations.size() + 1));
        allocations.add(allocation);
        return Optional.of(allocation);
    }

    @Override
    public Optional<Allocation> findLatest() {
        return allocations.size() == 0
                ? Optional.empty()
                : Optional.of(allocations.get(allocations.size() - 1));
    }
}
