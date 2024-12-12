package com.airline.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;
    
    @GetMapping("/flight/{flightId}")
    public ResponseEntity<List<Ticket>> getAvailableTickets(@PathVariable Long flightId) {
        return ResponseEntity.ok(ticketService.getAvailableTickets(flightId));
    }
    
    @PostMapping("/book")
    public ResponseEntity<Ticket> bookTicket(@RequestBody TicketBookingRequest request) {
        return ResponseEntity.ok(ticketService.bookTicket(request));
    }
    
    @PostMapping("/purchase")
    public ResponseEntity<Ticket> purchaseTicket(@RequestBody TicketPurchaseRequest request) {
        return ResponseEntity.ok(ticketService.purchaseTicket(request));
    }
} 