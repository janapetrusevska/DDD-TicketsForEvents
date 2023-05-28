package mk.ukim.finki.eventticket.domain.models;

import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class EventId extends DomainObjectId {
    private EventId() {
        super(EventId.randomId(EventId.class).getId());
    }

    public EventId(@NonNull String uuid) {
        super(uuid);
    }

    public static EventId of(String uuid) {
        EventId eventId = new EventId(uuid);
        return eventId;
    }
}
