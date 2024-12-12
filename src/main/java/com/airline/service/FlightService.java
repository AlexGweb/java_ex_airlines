package com.airline.service;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import com.airline.domain.Flight;
import com.airline.repository.FlightRepository;
import com.airline.repository.AircraftRepository;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    private final AircraftRepository aircraftRepository;
    
    public Flight createFlight(Flight flight) {
        validateFlight(flight);
        return flightRepository.save(flight);
    }
    
    private void validateFlight(Flight flight) {
        if (flight.getDepartureTime().isBefore(LocalDateTime.now().plusHours(1))) {
            throw new IllegalArgumentException("Flight must be scheduled at least 1 hour in advance");
        }
        
        boolean aircraftBusy = flightRepository.existsByAircraftAndDepartureTimeBetween(
            flight.getAircraft(),
            flight.getDepartureTime().minusHours(2),
            flight.getDepartureTime().plusHours(2)
        );
        
        if (aircraftBusy) {
            throw new IllegalStateException("Aircraft is already scheduled for another flight");
        }
    }
} 