package io.bensing.kernel.values;

import io.bensing.kernel.values.EmailAddress;
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
        Assertions.assertEquals("some.person@gmail.com", emailAddress.toString());
        Assertions.assertTrue(emailAddress.IsValid());
    }

    @Test
    @Tag("Small")
    @DisplayName("EmailAddress.isValid() should be false, with message of '[email address] is not valid email address.'")
    public void CheckForInvalidEmailAddress() {
        var emailAddress = new EmailAddress(".person@gmail.com");
        var expectedMessage = "'.person@gmail.com' is not a valid email address.";
        Assertions.assertFalse(emailAddress.IsValid());
        Assertions.assertEquals(expectedMessage, emailAddress.ValidationMessage());

    }
}