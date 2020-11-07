package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Allocation;
import com.thoughtworks.capability.gtb.restfulapidesign.service.AllocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/allocations")
public class AllocationController {
    private final AllocationService allocationService;

    public AllocationController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @PostMapping
    public ResponseEntity<Allocation> newAllocation() {
        Optional<Allocation> optionalAllocation = allocationService.createAllocation();
        if (optionalAllocation.isPresent()) {
            Allocation allocation = optionalAllocation.get();
            return ResponseEntity.created(URI.create("/allocations/" + allocation.getId()))
                    .body(allocation);
        } else {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .build();
        }
    }

    @GetMapping("/latest")
    public ResponseEntity<Allocation> getLatestAllocation() {
        Optional<Allocation> optionalAllocation = allocationService.getLatestAllocation();
        return optionalAllocation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
