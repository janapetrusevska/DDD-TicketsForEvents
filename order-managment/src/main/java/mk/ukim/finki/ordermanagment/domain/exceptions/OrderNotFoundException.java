package mk.ukim.finki.ordermanagment.domain.exceptions;

import mk.ukim.finki.ordermanagment.domain.model.OrderId;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(OrderId orderId) {
        super(String.format("Order with id: %d is not found", orderId));
    }
}
