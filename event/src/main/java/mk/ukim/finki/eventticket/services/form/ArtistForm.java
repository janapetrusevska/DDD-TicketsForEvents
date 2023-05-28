package mk.ukim.finki.eventticket.services.form;

import lombok.Data;
import mk.ukim.finki.sharedkernel.domain.valueObjects.FullName;

@Data
public class ArtistForm {

    private FullName fullName;

    private String artistName;

    private String description;
}
