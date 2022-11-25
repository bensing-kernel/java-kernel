package io.bensing.kernel.values;

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

        Assertions.assertEquals(surname.getValue(), "Bill");
    }

    @Test
    @Tag("Small")
    @DisplayName("Convert null input into empty string")
    public void NullInputIntoEmptyString() {
        var surname = new Name(null);

        Assertions.assertEquals(surname.getValue(), "");
    }

    @Test
    @Tag("Small")
    @DisplayName("Remove all line breaks from string")
    public void RemoveLineBreaks() {
        var surname = new Name("Two\nWords\r");

        Assertions.assertEquals("TwoWords", surname.getValue());
    }

}
