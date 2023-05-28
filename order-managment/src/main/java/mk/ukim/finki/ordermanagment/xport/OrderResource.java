package mk.ukim.finki.ordermanagment.xport;

import lombok.AllArgsConstructor;
import mk.ukim.finki.ordermanagment.domain.model.Order;
import mk.ukim.finki.ordermanagment.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/tickets")
@AllArgsConstructor
public class OrderResource {

    private final OrderService orderService;

    @GetMapping
    public List<Order> findAll(){
        return orderService.findAll();
    }
}


