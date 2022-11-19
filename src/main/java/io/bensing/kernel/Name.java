package io.bensing.kernel;

public class Name {

    private TrimmedString name;

    public Name(String name) {
        this.name = new TrimmedString(name);
    }

    public String getValue() {
        return this.name.getValue();
    }
}
