package io.bensing.kernel.values;

import io.bensing.kernel.CleanString;
import io.bensing.kernel.interfaces.ValueObject;

public class Name implements ValueObject<String> {

    private CleanString name;

    /**
     * Name generates a single-line string devoid of leading/trailing spaces.
     * @param name The name value
     */
    public Name(String name) {
        this.name = new CleanString(name);
        this.name = new CleanString(this.removeLineBreaks(this.name.toString()));
    }
    public String getValue() {
        return this.name.toString();
    }
    private String removeLineBreaks(String name) {
        name = name.replace("\n", "");
        name = name.replace("\r", "");
        return name;
    }

}
