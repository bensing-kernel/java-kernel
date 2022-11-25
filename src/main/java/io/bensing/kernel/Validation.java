package io.bensing.kernel;

public class Validation {

    private boolean valid;
    private String message = "";

    public Validation() { }

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
