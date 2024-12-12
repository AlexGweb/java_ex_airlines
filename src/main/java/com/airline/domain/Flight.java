@Entity
@Table(name = "flights")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    private String departureAirport;
    
    @NotEmpty
    private String arrivalAirport;
    
    @Future
    private LocalDateTime departureTime;
    
    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;
    
    @Enumerated(EnumType.STRING)
    private FlightStatus status;
} 