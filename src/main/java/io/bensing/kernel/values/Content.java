package io.bensing.kernel.values;

import io.bensing.kernel.CleanString;
import io.bensing.kernel.interfaces.ValueObject;

public class Content implements ValueObject<String> {

    private final CleanString content;

    /**
     * Content generates a multi-line string devoid of leading/trailing spaces.
     * @param content The content to populate
     */
    public Content(String content) {
        this.content = new CleanString(content);
    }

    public String getValue() {
        return this.content.toString();
    }

}
