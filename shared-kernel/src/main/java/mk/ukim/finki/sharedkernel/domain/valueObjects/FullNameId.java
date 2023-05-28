package mk.ukim.finki.sharedkernel.domain.valueObjects;

import mk.ukim.finki.sharedkernel.domain.base.DomainObjectId;

public class FullNameId extends DomainObjectId {
    private FullNameId() {
        super(FullNameId.randomId(FullNameId.class).getId());
    }

    public FullNameId(String uuid) {
        super(uuid);
    }
}
