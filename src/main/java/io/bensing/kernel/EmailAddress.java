package io.bensing.kernel;

import java.util.regex.Pattern;

public class EmailAddress implements Validatable {

    private static final String emailRegex = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
    private String emailAddress;
    private final Validation emailValidation = new Validation();

    /***
     * Creates an Email Address compliant with RFC 5322 standards.
     * Reference: <a href="https://howtodoinjava.com/regex/java-regex-validate-email-address/">Java Regex Validate Email Address</a>
     * @param emailAddress the input email address
     */
    EmailAddress(String emailAddress)  {
        this.setEmailAddress(emailAddress);
    }

    public String toString() {
        return this.emailAddress;
    }

    private void setEmailAddress(String emailAddress) {
        var trimmedEmail = new CleanString(emailAddress);
        this.emailAddress = this.validateEmailAddress(trimmedEmail.toString());
    }

    private String validateEmailAddress(String emailAddress) {
        var isValid = EMAIL_PATTERN.matcher(emailAddress).find();
        if (!isValid) {
            this.emailValidation.setAsInvalid("'" + emailAddress + "' is not a valid email address.");
        } else {
            this.emailValidation.setAsValid();
        }
        return emailAddress;
    }

    public boolean IsValid() {
        return this.emailValidation.isValid();
    }

    public String ValidationMessage() {
        return this.emailValidation.getValidationMessage();
    }
}