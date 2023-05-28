package mk.ukim.finki.eventticket.domain.repository;

import mk.ukim.finki.eventticket.domain.models.Event;
import mk.ukim.finki.eventticket.domain.models.EventId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, EventId> {
}
