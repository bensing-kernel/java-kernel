package io.bensing.kernel;

/**
 * TrimmedString is a value object with removes all spaces from the start and end of a string value.
 *
 * @param value The value to trim
 */
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
