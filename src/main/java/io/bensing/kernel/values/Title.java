package io.bensing.kernel.values;

import io.bensing.kernel.strings.CleanString;
import io.bensing.kernel.interfaces.Comparable;
import io.bensing.kernel.interfaces.ValueObject;

public class Title implements ValueObject<String>, Comparable<Title> {

    private CleanString name;

    /**
     * Title generates a single-line string devoid of leading/trailing spaces.
     * @param name The name value
     */
    public Title(String name) {
        this.name = new CleanString(name);
        this.name = new CleanString(this.removeLineBreaks(this.name.toString()));
    }
    public String Value() {
        return this.name.toString();
    }
    private String removeLineBreaks(String name) {
        name = name.replace("\n", "");
        name = name.replace("\r", "");
        return name;
    }
    public boolean Equals(Title title) {
        return this.name.toString() == title.name.toString();
    }
}
