package mk.ukim.finki.ordermanagment.domain.model;

import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;

public class TicketId extends DomainObjectId {
    private TicketId() {
        super(TicketId.randomId(TicketId.class).getId());
    }

    public TicketId(String uuid) {
        super(uuid);
    }
}
