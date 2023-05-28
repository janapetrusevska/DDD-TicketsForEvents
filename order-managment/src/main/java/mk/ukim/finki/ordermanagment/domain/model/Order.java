package mk.ukim.finki.ordermanagment.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.ordermanagment.domain.valueobjects.Event;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.sharedkernel.domain.financial.Money;


import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="orders")
@Getter
public class Order extends AbstractEntity<OrderId> {

    @Column(name="order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    private Money fullPrice;

    private Set<Ticket> ticketsList = new HashSet<>();

    private Order() {
        super(OrderId.randomId(OrderId.class));
    }

    public Order(Instant now, mk.ukim.finki.sharedkernel.domain.financial.Currency currency) {
        super(OrderId.randomId(OrderId.class));
        this.currency = currency;
        this.fullPrice= new Money(currency,0);
    }

    public Money total() {
        return ticketsList.stream().map(Ticket::subtotal).reduce(new Money(currency, 0), Money::add);
    }

    public Ticket addTicket(@NonNull Ticket ticket, int quantity) {
        Objects.requireNonNull(ticket,"ticket must not be null");
        var item  = new Ticket(ticket.getEventId(),ticket.getTicketPrice(),ticket.getTicketType(),quantity);
        ticketsList.add(item);
        return item;
    }

    public void removeTicket(@NonNull TicketId ticketId) {
        Objects.requireNonNull(ticketId,"Ticket must not be null");
        ticketsList.removeIf(v->v.getId().equals(ticketId));
    }
}
