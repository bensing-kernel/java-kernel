package io.bensing.kernel.values;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TitleTests {

    @Test
    @Tag("Small")
    @DisplayName("Instantiate Name")
    public void InstantiateName() {
        var surname = new Title("Bill");

        Assertions.assertEquals(surname.Value(), "Bill");
    }

    @Test
    @Tag("Small")
    @DisplayName("Convert null input into empty string")
    public void NullInputIntoEmptyString() {
        var surname = new Title(null);

        Assertions.assertEquals(surname.Value(), "");
    }

    @Test
    @Tag("Small")
    @DisplayName("Remove all line breaks from string")
    public void RemoveLineBreaks() {
        var surname = new Title("Two\nWords\r");

        Assertions.assertEquals("TwoWords", surname.Value());
    }

}
