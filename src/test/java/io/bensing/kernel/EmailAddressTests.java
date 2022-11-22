package io.bensing.kernel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Kernel - Value Object - Email Address")
public class EmailAddressTests {

    @Test
    @Tag("Small")
    public void InstantiateEmailAddress() {

        var email = new EmailAddress("some.person@gmail.com");
        Assertions.assertEquals("some.person@gmail.com", email.getValue());

    }

//    @Test
//    @Tag("Small")
//    @DisplayName("Should throw an IllegalArgumentException when an invalid email address is supplied.")
//    public void ThrowErrorForInvalidEmailAddress() {
//
//        var exception = assertThrows(IllegalArgumentException.class, () -> EmailAddress.Of(".person@gmail.com"));
//        Assertions.assertEquals("This is not valid email address '.person@gmail.com'.", exception.getMessage());
//
//    }
}