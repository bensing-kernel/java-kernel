package io.bensing.kernel.values;

import io.bensing.kernel.CleanString;

public class Name {

    private CleanString name;

    /**
     * Name is a value object which generates a valid name string.
     * @param name The name value
     */
    public Name(String name) {
        this.name = new CleanString(name);
        this.name = new CleanString(this.removeLineBreaks(this.name.toString()));
    }
    public String toString() {
        return this.name.toString();
    }
    private String removeLineBreaks(String name) {
        name = name.replace("\n", "");
        name = name.replace("\r", "");
        return name;
    }

}
