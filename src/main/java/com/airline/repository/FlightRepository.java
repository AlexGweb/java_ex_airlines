@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureTimeBetween(
        String departureAirport,
        String arrivalAirport,
        LocalDateTime startTime,
        LocalDateTime endTime
    );
} 