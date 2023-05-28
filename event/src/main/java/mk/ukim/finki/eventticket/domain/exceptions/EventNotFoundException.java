package mk.ukim.finki.eventticket.domain.exceptions;

import mk.ukim.finki.eventticket.domain.models.EventId;

public class EventNotFoundException extends RuntimeException{
    public EventNotFoundException(EventId id) {
        super(String.format("Event with id: %d is not found", id));
    }
}

