package mk.ukim.finki.eventticket.domain.models;

import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class ArtistId extends DomainObjectId {
    private ArtistId() {
        super(ArtistId.randomId(ArtistId.class).getId());
    }

    public ArtistId(@NonNull String uuid) {
        super(uuid);
    }

    public static ArtistId of(String uuid) {
        ArtistId artistId = new ArtistId(uuid);
        return artistId;
    }
}
