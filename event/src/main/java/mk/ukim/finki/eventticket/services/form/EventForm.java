package mk.ukim.finki.eventticket.services.form;

import lombok.Data;
import mk.ukim.finki.sharedkernel.domain.base.enumeration.EventType;

import java.time.LocalDate;

@Data
public class EventForm {

    String eventName;

    LocalDate date;

    EventType eventType;

    Integer durationDays;

    Integer numberOfTickets;

}
