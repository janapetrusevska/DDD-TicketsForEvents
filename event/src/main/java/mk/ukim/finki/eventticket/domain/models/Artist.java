package mk.ukim.finki.eventticket.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.sharedkernel.domain.valueObjects.FullName;
import mk.ukim.finki.sharedkernel.domain.base.AbstractEntity;


@Entity
@Table(name="artists")
@Getter
public class Artist extends AbstractEntity<ArtistId> {

    private FullName fullName;

    private String artistName;

    private String description;

    public Artist(){
        super(ArtistId.randomId(ArtistId.class));
    }

    public static Artist build(FullName fullName, String artistName, String description) {
        Artist a = new Artist();
        a.artistName = artistName;
        a.fullName = fullName;
        a.description = description;
        return a;
    }
}
