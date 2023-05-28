package mk.ukim.finki.eventticket.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.eventticket.domain.exceptions.EventNotFoundException;
import mk.ukim.finki.eventticket.domain.models.Event;
import mk.ukim.finki.eventticket.domain.models.EventId;
import mk.ukim.finki.eventticket.domain.repository.EventRepository;
import mk.ukim.finki.eventticket.services.EventService;
import mk.ukim.finki.eventticket.services.form.EventForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Override
    public List<Event> getAll() {
        return this.eventRepository.findAll();
    }

    @Override
    public Event findById(EventId eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException(eventId));
        return event;
    }

    @Override
    public Event createEvent(EventForm eventForm) {
        Event event = Event.build(eventForm.getEventName(),eventForm.getDate(),eventForm.getEventType(),eventForm.getDurationDays(),eventForm.getNumberOfTickets());
        eventRepository.save(event);
        return event;
    }

    @Override
    public Event editEvent(EventId eventId, EventForm eventForm) {
        Event event = this.eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException(eventId));
        event.setEventName(eventForm.getEventName());
        event.setDate(eventForm.getDate());
        event.setEventType(eventForm.getEventType());
        event.setDurationDays(eventForm.getDurationDays());
        event.setNumberOfTickets(eventForm.getNumberOfTickets());
        this.eventRepository.save(event);
        return event;
    }

    @Override
    public Event deleteEvent(EventId eventId) {
        Event event = this.eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException(eventId));
        this.eventRepository.delete(event);
        return event;
    }

    @Override
    public Event reduceNumberOfTickets(EventId eventId, int quantity) {
        Event event = this.eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException(eventId));
        event.buyTickets(quantity);
        this.eventRepository.save(event);
        return event;
    }
}
