package mk.ukim.finki.eventticket.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.sharedkernel.domain.base.enumeration.EventType;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="events")
@Getter
public class Event extends AbstractEntity<EventId> {

    private String eventName;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    private Integer durationDays;

    @OneToMany
    private Set<Artist> artists = new HashSet<>();

    private Integer numberOfTickets;

    public Event(){
        super(EventId.randomId(EventId.class));
    }

    public static Event build(String eventName, LocalDate date, EventType eventType, Integer durationDays, Integer numberOfTickets) {
        Event e = new Event();
        e.eventName = eventName;
        e.date = date;
        e.eventType = eventType;
        e.durationDays = durationDays;
        e.numberOfTickets = numberOfTickets;
        return e;
    }

    public void buyTickets(int quantity) {
        this.numberOfTickets = this.numberOfTickets - quantity;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public void setDurationDays(Integer durationDays) {
        this.durationDays = durationDays;
    }

    public void setNumberOfTickets(Integer numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
