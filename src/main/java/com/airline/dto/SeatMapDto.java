@Data
@Builder
public class SeatMapDto {
    private Long flightId;
    private List<List<SeatDto>> seatMap;
}

@Data
@Builder
public class SeatDto {
    private String seatNumber;
    private SeatStatus status;
    private BigDecimal price;
} 