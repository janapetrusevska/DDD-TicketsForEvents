package mk.ukim.finki.sharedkernel.domain.valueObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.sharedkernel.domain.base.ValueObject;

@Getter
public class FullName implements ValueObject {
    private final FullNameId id;
    private final String name;
    private final String surname;

    private FullName() {
        this.id=FullNameId.randomId(FullNameId.class);
        this.name= "";
        this.surname="";
    }
    @JsonCreator
    public FullName(@JsonProperty("id") FullNameId id,
                    @JsonProperty("name") String name,
                    @JsonProperty("surname") String surname, String surname1) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
