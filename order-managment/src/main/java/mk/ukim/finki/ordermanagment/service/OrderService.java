package mk.ukim.finki.ordermanagment.service;

import mk.ukim.finki.ordermanagment.domain.exceptions.OrderIdNotExistException;
import mk.ukim.finki.ordermanagment.domain.exceptions.TicketNotFoundException;
import mk.ukim.finki.ordermanagment.domain.model.Order;
import mk.ukim.finki.ordermanagment.domain.model.OrderId;
import mk.ukim.finki.ordermanagment.domain.model.Ticket;
import mk.ukim.finki.ordermanagment.service.form.OrderForm;
import mk.ukim.finki.ordermanagment.service.form.TicketForm;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAll();

    Optional<Order> findById(OrderId id);

    void addTicket(OrderId orderId, TicketForm ticketForm) throws OrderIdNotExistException;

    void deleteTicket(OrderId orderId, TicketForm ticketForm) throws OrderIdNotExistException, TicketNotFoundException;
}
