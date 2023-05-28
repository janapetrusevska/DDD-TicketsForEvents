package mk.ukim.finki.ordermanagment.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.ordermanagment.domain.exceptions.OrderIdNotExistException;
import mk.ukim.finki.ordermanagment.domain.exceptions.TicketNotFoundException;
import mk.ukim.finki.ordermanagment.domain.model.Order;
import mk.ukim.finki.ordermanagment.domain.model.OrderId;
import mk.ukim.finki.ordermanagment.domain.repository.OrderRepository;
import mk.ukim.finki.ordermanagment.service.OrderService;
import mk.ukim.finki.ordermanagment.service.form.TicketForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(OrderId id) {
        return orderRepository.findById(id);
    }

    @Override
    public void addTicket(OrderId orderId, TicketForm ticketForm) throws OrderIdNotExistException {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderIdNotExistException::new);
        order.addTicket(ticketForm.getTicket(),ticketForm.getOrderedQuantity());
        orderRepository.saveAndFlush(order);
    }

    @Override
    public void deleteTicket(OrderId orderId, TicketForm ticketForm) throws OrderIdNotExistException, TicketNotFoundException {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderIdNotExistException::new);
        order.removeTicket(ticketForm.getTicket().getId());
        orderRepository.saveAndFlush(order);
    }
}
