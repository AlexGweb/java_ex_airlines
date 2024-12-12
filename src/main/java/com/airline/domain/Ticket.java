@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
    
    private String seatNumber;
    
    @NotNull
    private BigDecimal price;
    
    @Enumerated(EnumType.STRING)
    private TicketStatus status;
} 