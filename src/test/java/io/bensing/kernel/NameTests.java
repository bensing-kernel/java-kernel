package io.bensing.kernel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("io.bensing.kernel - Name")
public class NameTests {

    @Test
    @Tag("Small")
    @DisplayName("Instantiate Surname")
    public void InstantiateSurname() {
        var surname = new Name("Bill");

        Assertions.assertEquals(surname.getValue(), "Bill");
    }
}
