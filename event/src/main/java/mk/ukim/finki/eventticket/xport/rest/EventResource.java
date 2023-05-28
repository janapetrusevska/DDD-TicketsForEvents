package mk.ukim.finki.eventticket.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.eventticket.domain.models.Event;
import mk.ukim.finki.eventticket.services.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/events")
@AllArgsConstructor
public class EventResource {

    private final EventService eventService;

    @GetMapping
    public List<Event> findAll(){
        return eventService.getAll();
    }
}
