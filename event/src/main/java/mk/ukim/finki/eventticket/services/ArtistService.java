package mk.ukim.finki.eventticket.services;

import mk.ukim.finki.eventticket.domain.models.Artist;
import mk.ukim.finki.eventticket.domain.models.ArtistId;
import mk.ukim.finki.eventticket.services.form.ArtistForm;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    List<Artist> getAll();

    Artist findById(ArtistId artistId);

    Artist createArtist(ArtistForm artistForm);
}
