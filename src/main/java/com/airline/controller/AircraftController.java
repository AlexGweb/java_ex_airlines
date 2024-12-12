package com.airline.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.airline.domain.Aircraft;
import com.airline.service.AircraftService;
import java.util.List;

@RestController
@RequestMapping("/api/aircraft")
@RequiredArgsConstructor
public class AircraftController {
    private final AircraftService aircraftService;
    
    @PostMapping
    public ResponseEntity<Aircraft> addAircraft(@Valid @RequestBody Aircraft aircraft) {
        return ResponseEntity.ok(aircraftService.addAircraft(aircraft));
    }
    
    @PutMapping("/{id}/decommission")
    public ResponseEntity<Void> decommissionAircraft(@PathVariable Long id) {
        aircraftService.decommissionAircraft(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping
    public ResponseEntity<List<Aircraft>> getOperationalAircraft() {
        return ResponseEntity.ok(aircraftService.getAllOperationalAircraft());
    }
} 