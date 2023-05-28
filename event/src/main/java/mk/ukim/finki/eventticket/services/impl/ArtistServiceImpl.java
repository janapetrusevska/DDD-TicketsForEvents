package mk.ukim.finki.eventticket.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.eventticket.domain.exceptions.ArtistNotFoundException;
import mk.ukim.finki.eventticket.domain.models.Artist;
import mk.ukim.finki.eventticket.domain.models.ArtistId;
import mk.ukim.finki.eventticket.domain.repository.ArtistRepository;
import mk.ukim.finki.eventticket.services.ArtistService;
import mk.ukim.finki.eventticket.services.form.ArtistForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    @Override
    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findById(ArtistId artistId) {
        Artist artist = this.artistRepository.findById(artistId).orElseThrow(() -> new ArtistNotFoundException(artistId));
        return artist;
    }

    @Override
    public Artist createArtist(ArtistForm artistForm) {
        Artist artist = Artist.build(artistForm.getFullName(),artistForm.getArtistName(),artistForm.getDescription());
        artistRepository.save(artist);
        return artist;
    }
}
