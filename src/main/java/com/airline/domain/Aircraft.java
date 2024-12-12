@Entity
@Table(name = "aircrafts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    private String model;
    
    @Min(0)
    private Integer cargoCapacity;
    
    @Past
    private LocalDate manufactureDate;
    
    @NotEmpty
    private String registrationNumber;
    
    @NotEmpty
    private String contractNumber;
    
    @ElementCollection
    private List<List<String>> seatConfiguration;
    
    private boolean inOperation;
} 