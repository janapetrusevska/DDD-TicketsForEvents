package mk.ukim.finki.ordermanagment.domain.valueobjects;

import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;
@Embeddable
public class EventId extends DomainObjectId {
    public EventId() {
        super(EventId.randomId(EventId.class).getId());
    }

    public EventId(String uuid) {
        super(uuid);
    }
}