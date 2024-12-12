package com.airline.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketService {
    private final TicketRepository ticketRepository;
    private final FlightRepository flightRepository;
    
    @Transactional
    public Ticket bookTicket(TicketBookingRequest request) {
        return ticketRepository.findById(request.getTicketId())
            .filter(ticket -> ticket.getStatus() == TicketStatus.AVAILABLE)
            .map(ticket -> {
                synchronized (getLockKey(ticket.getFlight().getId(), ticket.getSeatNumber())) {
                    if (ticket.getStatus() != TicketStatus.AVAILABLE) {
                        throw new ConcurrentModificationException("Ticket is no longer available");
                    }
                    ticket.setStatus(TicketStatus.BOOKED);
                    return ticketRepository.save(ticket);
                }
            })
            .orElseThrow(() -> new EntityNotFoundException("Ticket not found or not available"));
    }
    
    private String getLockKey(Long flightId, String seatNumber) {
        return String.format("flight_%d_seat_%s", flightId, seatNumber);
    }
    
    public void cancelBooking(Long ticketId) {
        // Отмена брони
        // Освобождение места
    }
} 