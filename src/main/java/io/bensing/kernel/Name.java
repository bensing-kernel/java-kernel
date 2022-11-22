package io.bensing.kernel;

public class Name {

    private TrimmedString name;

    /**
     * Name is a value object which generates a valid name string.
     * @param name The name value
     */
    public Name(String name) {
        if(name == null) {
            name = "";
        }
        this.name = new TrimmedString(name);
    }

    public String getValue() {
        return this.name.getValue();
    }

}
