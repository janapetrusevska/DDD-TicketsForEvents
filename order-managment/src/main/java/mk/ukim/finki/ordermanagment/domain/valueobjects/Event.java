package mk.ukim.finki.ordermanagment.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.sharedkernel.domain.base.enumeration.EventType;

import java.time.LocalDate;

@Getter
public class Event implements ValueObject{

    private final EventId id;
    private final String eventName;
    private final LocalDate date;
    private final EventType eventType;
    private final Integer durationDays;
    private final Integer numberOfTickets;

    private Event() {
        this.id=EventId.randomId(EventId.class);
        this.eventName= "";
        this.date = LocalDate.now();
        this.eventType=EventType.CONCERT;
        this.durationDays=0;
        this.numberOfTickets = 0;
    }

    @JsonCreator
    public Event(@JsonProperty("eventId") EventId id,
                 @JsonProperty("eventName") String eventName,
                 @JsonProperty("date")LocalDate date,
                 @JsonProperty("eventType")EventType eventType,
                 @JsonProperty("durationDays")Integer durationDays,
                 @JsonProperty("numberOfTickets")Integer numberOfTickets) {
        this.id=id;
        this.eventName = eventName;
        this.date = date;
        this.eventType = eventType;
        this.durationDays = durationDays;
        this.numberOfTickets = numberOfTickets;
    }
}
