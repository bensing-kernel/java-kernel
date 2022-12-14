package io.bensing.kernel.strings;

public class CleanString {

    private String value;

    /**
     * CleanString removes all spaces from the start and end of a string value, and converts a null string argument into an empty string.
     * @param value The value to clean
     */
    public CleanString(String value) {
        this.value = value;
        this.value = this.fixNullString(this.value);
        this.value = this.value.trim();
    }

    public String toString() {
        return this.value;
    }

    private String fixNullString(String value) {
        return value == null ? "" : value;
    }

}
