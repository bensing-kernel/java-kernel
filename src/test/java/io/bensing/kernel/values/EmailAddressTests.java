package io.bensing.kernel.values;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class EmailAddressTests {

    @Test
    @Tag("Small")
    @DisplayName("Successfully instantiate EmailAddress")
    public void InstantiateEmailAddress() {
        var emailAddress = new EmailAddress("some.person@gmail.com");
        Assertions.assertEquals("some.person@gmail.com", emailAddress.Value(),
                "The expected email address value was not returned.");
        Assertions.assertTrue(emailAddress.IsValid(), "Expected IsValid to be 'true'.");
        Assertions.assertFalse(emailAddress.IsInvalid(), "Expected IsInvalid to be 'false'.");
    }

    @Test
    @Tag("Small")
    @DisplayName("EmailAddress.isValid() should be false, with message of '[email address] is not valid email address.'")
    public void CheckForInvalidEmailAddress() {
        var emailAddress = new EmailAddress(".person@gmail.com");
        var expectedMessage = "'.person@gmail.com' is not a valid email address.";
        Assertions.assertFalse(emailAddress.IsValid(), "Expected IsValid to be 'false'.");
        Assertions.assertTrue(emailAddress.IsInvalid(), "Expected IsInvalid to be 'true'.");
        Assertions.assertTrue(emailAddress.ValidationMessages().contains(expectedMessage),
                "The expected validation message was not returned.");
    }

    @Test
    @Tag("Small")
    @DisplayName("Two (2) of the same Email Addresses equal.")
    public void EmailAddressesEqual() {
        var email1 = new EmailAddress("hello@gmail.com");
        var email2 = new EmailAddress("hello@gmail.com");
        Assertions.assertTrue(email1.Equals(email2), "Expected both email addresses TO EQUAL each other.");
    }

    @Test
    @Tag("Small")
    @DisplayName("Two (2) differing Email Addresses do not equal.")
    public void EmailAddressesDoNotEqual() {
        var email1 = new EmailAddress("firstEmail@gmail.com");
        var email2 = new EmailAddress("secondEmail@gmail.com");
        Assertions.assertFalse(email1.Equals(email2), "Expected both email addresses TO NOT EQUAL each other.");
    }

}