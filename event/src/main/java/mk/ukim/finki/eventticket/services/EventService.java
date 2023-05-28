package mk.ukim.finki.eventticket.services;


import mk.ukim.finki.eventticket.domain.models.Event;
import mk.ukim.finki.eventticket.domain.models.EventId;
import mk.ukim.finki.eventticket.services.form.EventForm;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> getAll();

    Event findById(EventId eventId);

    Event createEvent(EventForm eventForm);

    Event editEvent(EventId id, EventForm eventForm);

    Event deleteEvent(EventId eventId);

    Event reduceNumberOfTickets(EventId eventId, int quantity);
}
