package mk.ukim.finki.eventticket.domain.exceptions;

import mk.ukim.finki.eventticket.domain.models.ArtistId;

public class ArtistNotFoundException extends RuntimeException{
    public ArtistNotFoundException(ArtistId id) {
        super(String.format("Artist with id: %d is not found", id));
    }
}

