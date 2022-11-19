package io.bensing.kernel;

/**
 * Name is a value object which generates a valid name string.
 *
 * @param name The name value
 */
public class Name {

    private TrimmedString name;

    public Name(String name) {
        this.name = new TrimmedString(name);
    }

    public String getValue() {
        return this.name.getValue();
    }

}
