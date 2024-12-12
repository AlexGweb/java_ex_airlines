@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {
    private Long id;
    
    @NotEmpty(message = "Departure airport is required")
    @Size(min = 3, max = 3, message = "Airport code must be 3 characters")
    private String departureAirport;
    
    @NotEmpty(message = "Arrival airport is required")
    @Size(min = 3, max = 3, message = "Airport code must be 3 characters")
    private String arrivalAirport;
    
    @Future(message = "Departure time must be in the future")
    private LocalDateTime departureTime;
    
    private AircraftDto aircraft;
    private FlightStatus status;
    private List<TicketDto> availableTickets;
} 