package io.bensing.kernel;

// TODO - Create the Validation object to track validation state & Test It
public class Validation {

    private boolean valid;
    private String message = "";

    Validation() { }

    public void setAsValid() {
        this.message = "";
        this.valid = true;
    }

    public void setAsInvalid(String message) {
        this.message = message;
        this.valid = false;
    }

    public void Reset() {
        this.setAsInvalid("");
    }

    public boolean isValid() {
        return this.valid;
    }

    public boolean isInvalid() {
        return !this.isValid();
    }

    public String getValidationMessage() {
        return this.message;
    }

}
