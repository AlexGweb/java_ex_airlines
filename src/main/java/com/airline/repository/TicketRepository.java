@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByFlightAndStatus(Flight flight, TicketStatus status);
} 