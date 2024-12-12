package com.airline.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.airline.domain.Aircraft;
import com.airline.repository.AircraftRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AircraftService {
    private final AircraftRepository aircraftRepository;
    
    public Aircraft addAircraft(Aircraft aircraft) {
        aircraft.setInOperation(true);
        return aircraftRepository.save(aircraft);
    }
    
    public void decommissionAircraft(Long id) {
        Aircraft aircraft = aircraftRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Aircraft not found"));
        aircraft.setInOperation(false);
        aircraftRepository.save(aircraft);
    }
    
    public List<Aircraft> getAllOperationalAircraft() {
        return aircraftRepository.findByInOperationTrue();
    }
} 