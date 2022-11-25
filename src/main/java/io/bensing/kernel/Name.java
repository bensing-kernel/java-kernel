package io.bensing.kernel;

public class Name {

    private CleanString name;

    /**
     * Name is a value object which generates a valid name string.
     * @param name The name value
     */
    public Name(String name) {
        if(name == null) {
            name = "";
        }
        this.name = new CleanString(name);
    }

    public String toString() {
        return this.name.getValue();
    }

}
