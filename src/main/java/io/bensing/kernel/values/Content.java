package io.bensing.kernel.values;

import io.bensing.kernel.CleanString;
import io.bensing.kernel.interfaces.Comparable;
import io.bensing.kernel.interfaces.ValueObject;

public class Content implements ValueObject<String>, Comparable<Content> {

    private final CleanString content;

    /**
     * Content generates a multi-line string devoid of leading/trailing spaces.
     * @param content The content to populate
     */
    public Content(String content) {
        this.content = new CleanString(content);
    }

    public String Value() {
        return this.content.toString();
    }

    public boolean Equals(Content content) {
        return this.Value().equals(content.Value());
    }
}
