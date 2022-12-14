package io.bensing.kernel.identity;

import io.bensing.kernel.interfaces.Comparable;
import io.bensing.kernel.interfaces.ValueObject;

public class Id implements ValueObject<Long>, Comparable<Id> {

    long id;

    public Id(long id) {
        this.id = id;
    }

    @Override
    public Long Value() {
        return this.id;
    }

    @Override
    public boolean Equals(Id id) {
        return this.Value().equals(id.Value());
    }
}
