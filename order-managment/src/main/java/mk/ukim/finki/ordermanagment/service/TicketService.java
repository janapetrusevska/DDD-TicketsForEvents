package mk.ukim.finki.ordermanagment.service;


import mk.ukim.finki.ordermanagment.domain.model.Ticket;
import mk.ukim.finki.ordermanagment.domain.model.TicketId;

import java.util.List;

public interface TicketService {
    List<Ticket> getAll();

    Ticket findById(TicketId ticketId);
}
