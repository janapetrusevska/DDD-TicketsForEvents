package mk.ukim.finki.ordermanagment.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.ordermanagment.domain.model.enumeration.TicketType;
import mk.ukim.finki.ordermanagment.domain.valueobjects.EventId;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.sharedkernel.domain.financial.Money;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name="tickets")
@Getter
public class Ticket extends AbstractEntity<TicketId> {

    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="price_amount")),
            @AttributeOverride(name="currency", column = @Column(name="price_currency"))
    })
    private Money ticketPrice;

    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    private int orderedQuantity;

    @AttributeOverride(name = "id", column = @Column(name = "event_id", nullable = false))
    private EventId eventId;

    private Ticket(){
        super(DomainObjectId.randomId(TicketId.class));
    }

    public Ticket(@NonNull EventId eventId, @NonNull Money ticketPrice, TicketType ticketType, int orderedQuantity) {
        super(DomainObjectId.randomId(TicketId.class));
        this.eventId=eventId;
        this.ticketPrice = ticketPrice;
        this.ticketType = ticketType;
        this.orderedQuantity = orderedQuantity;
    }

    public Money subtotal() {
        return ticketPrice.multiply(orderedQuantity);
    }

}
