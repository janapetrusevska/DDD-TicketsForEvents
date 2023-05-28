package mk.ukim.finki.ordermanagment.domain.exceptions;


import mk.ukim.finki.ordermanagment.domain.model.TicketId;

public class TicketNotFoundException extends RuntimeException{
    public TicketNotFoundException(TicketId id) {
        super(String.format("Ticket with id: %d is not found", id));
    }
}

