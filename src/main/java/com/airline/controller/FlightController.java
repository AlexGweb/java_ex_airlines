package com.airline.controller;

import com.airline.dto.FlightDto;
import com.airline.dto.SeatMapDto;
import com.airline.mapper.FlightMapper;
import com.airline.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;
    private final FlightMapper flightMapper;

    @GetMapping("/search")
    public ResponseEntity<List<FlightDto>> searchFlights(
            @RequestParam String departureAirport,
            @RequestParam String arrivalAirport,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime) {
        return ResponseEntity.ok(flightService.searchFlights(departureAirport, arrivalAirport, startTime, endTime)
                .stream()
                .map(flightMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}/seats")
    public ResponseEntity<SeatMapDto> getFlightSeatMap(@PathVariable Long id) {
        return ResponseEntity.ok(flightService.getFlightSeatMap(id));
    }
} 