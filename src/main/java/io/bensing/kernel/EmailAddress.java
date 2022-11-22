package io.bensing.kernel;

import java.util.regex.Pattern;

public class EmailAddress  {

    private static final String emailRegex = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
    private String emailAddress;

    /***
     * Creates an Email Address compliant with RFC 5322 standards.
     * Reference: <a href="https://howtodoinjava.com/regex/java-regex-validate-email-address/">Java Regex Validate Email Address</a>
     * @param emailAddress the input email address
     */
    EmailAddress(String emailAddress)  {
        this.setEmailAddress(emailAddress);
    }

    public String getValue() {
        return this.emailAddress;
    }

    private void setEmailAddress(String emailAddress) {
        var trimmedEmail = new TrimmedString(emailAddress);
        this.emailAddress = this.validateEmailAddress(trimmedEmail.getValue());
    }

    private String validateEmailAddress(String emailAddress) {
        var isValid = EMAIL_PATTERN.matcher(emailAddress).find();
        // Todo - Update to include .isValid() and validationMessage()
        // if(!isValid) { throw new IllegalArgumentException(String.format("This is not valid email address '%s'.", emailAddress)); }
        return emailAddress;
    }

}