package mk.ukim.finki.ordermanagment.domain.repository;
import mk.ukim.finki.ordermanagment.domain.model.Ticket;
import mk.ukim.finki.ordermanagment.domain.model.TicketId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, TicketId> {
}
