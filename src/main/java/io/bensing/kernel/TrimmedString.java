package io.bensing.kernel;

public class TrimmedString {

    private String value;

    TrimmedString(String value) {
        this.value = this.trim(value);
    }

    public String getValue() {
        return this.value;
    }

    private String trim(String value) {
        return value.trim();
    }
}
