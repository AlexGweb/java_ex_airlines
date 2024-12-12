package com.airline.service;

import com.airline.dto.SeatMapDto;
import com.airline.entity.Flight;
import com.airline.entity.Ticket;
import com.airline.repository.FlightRepository;
import com.airline.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatMapService {
    private final FlightRepository flightRepository;
    private final TicketRepository ticketRepository;

    public SeatMapDto generateSeatMap(Long flightId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new EntityNotFoundException("Flight not found"));
        
        List<Ticket> tickets = ticketRepository.findByFlight(flight);
        List<List<String>> seatConfig = flight.getAircraft().getSeatConfiguration();
        
        return SeatMapDto.builder()
                .flightId(flightId)
                .seatMap(generateSeatMapWithStatus(seatConfig, tickets))
                .build();
    }

    private List<List<SeatStatus>> generateSeatMapWithStatus(List<List<String>> config, List<Ticket> tickets) {
        // Логика генерации карты мест с их статусами
    }
} 