package io.bensing.kernel.values;

import io.bensing.kernel.strings.CleanString;
import io.bensing.kernel.Validation;
import io.bensing.kernel.interfaces.Comparable;
import io.bensing.kernel.interfaces.Validatable;
import io.bensing.kernel.interfaces.ValueObject;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class EmailAddress implements ValueObject<String>, Validatable, Comparable<EmailAddress> {

    private static final String emailRegex = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
    private CleanString emailAddress;
    private Validation emailValidation;

    /***
     * Creates an Email Address compliant with RFC 5322 standards.
     * Reference: <a href="https://howtodoinjava.com/regex/java-regex-validate-email-address/">Java Regex Validate Email Address</a>
     * @param emailAddress the input email address
     */
    public EmailAddress(String emailAddress)  {
        this.setEmailAddress(emailAddress);
        this.validate();
    }

    public boolean IsValid() {
        return this.emailValidation.IsValid();
    }
    public boolean IsInvalid() {
        return this.emailValidation.IsInvalid();
    }
    public ArrayList<String> ValidationMessages() {
        return this.emailValidation.ValidationMessages();
    }
    public int ValidationMessageCount() {
        return this.emailValidation.ValidationMessageCount();
    }

    public boolean Equals(EmailAddress email) {
        return this.emailAddress.toString().equals(email.Value());
    }
    public String Value() {
        return this.emailAddress.toString();
    }

    private void setEmailAddress(String emailAddress) {
        this.emailAddress = new CleanString(emailAddress);
    }
    private void validate() {
        this.emailValidation = new Validation();
        var isValid = EMAIL_PATTERN.matcher(this.emailAddress.toString()).find();
        if (!isValid) {
            this.emailValidation.AddMessage("'" + emailAddress + "' is not a valid email address.");
        }
    }


}