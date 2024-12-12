@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AircraftDto {
    private Long id;
    
    @NotEmpty(message = "Model is required")
    private String model;
    
    @Min(value = 0, message = "Cargo capacity must be positive")
    private Integer cargoCapacity;
    
    @Past(message = "Manufacture date must be in the past")
    private LocalDate manufactureDate;
    
    @NotEmpty(message = "Registration number is required")
    private String registrationNumber;
    
    @NotEmpty(message = "Contract number is required")
    private String contractNumber;
    
    private List<List<String>> seatConfiguration;
    
    private boolean inOperation;
} 