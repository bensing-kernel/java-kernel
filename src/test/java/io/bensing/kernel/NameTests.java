package io.bensing.kernel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class NameTests {

    @Test
    @Tag("Small")
    @DisplayName("Instantiate Name")
    public void InstantiateName() {
        var surname = new Name("Bill");

        Assertions.assertEquals(surname.toString(), "Bill");
    }

    @Test
    @Tag("Small")
    @DisplayName("Convert null input into empty string")
    public void NullInputIntoEmptyString() {
        var surname = new Name(null);

        Assertions.assertEquals(surname.toString(), "");
    }

}
