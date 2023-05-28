package mk.ukim.finki.ordermanagment.service.impl;

import lombok.AllArgsConstructor;

import mk.ukim.finki.ordermanagment.domain.exceptions.TicketNotFoundException;
import mk.ukim.finki.ordermanagment.domain.model.Ticket;
import mk.ukim.finki.ordermanagment.domain.model.TicketId;
import mk.ukim.finki.ordermanagment.domain.repository.TicketRepository;
import mk.ukim.finki.ordermanagment.service.TicketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAll() {
        return this.ticketRepository.findAll();
    }

    @Override
    public Ticket findById(TicketId ticketId) {
        Ticket ticket = this.ticketRepository.findById(ticketId).orElseThrow(() -> new TicketNotFoundException(ticketId));
        return ticket;
    }
}
