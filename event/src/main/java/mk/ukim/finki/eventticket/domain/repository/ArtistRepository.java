package mk.ukim.finki.eventticket.domain.repository;

import mk.ukim.finki.eventticket.domain.models.Artist;
import mk.ukim.finki.eventticket.domain.models.ArtistId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, ArtistId> {
}
