package mk.ukim.finki.eventticket.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.eventticket.domain.models.Artist;
import mk.ukim.finki.eventticket.domain.models.ArtistId;
import mk.ukim.finki.eventticket.services.ArtistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/artists")
@AllArgsConstructor
public class ArtistResource {

    private final ArtistService artistService;

    @GetMapping()
    public List<Artist> findAll(){
        return artistService.getAll();
    }
}
