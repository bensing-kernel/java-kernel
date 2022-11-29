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

    @Test
    @Tag("Small")
    @DisplayName("Two (2) of the same Titles equal.")
    public void TitlesEqual() {
        var t1 = new Title("Bill");
        var t2 = new Title("Bill");
        Assertions.assertTrue(t1.Equals(t2));
    }

    @Test
    @Tag("Small")
    @DisplayName("Two (2) differing Titles do not equal.")
    public void TitlesDoNotEqual() {
        var t1 = new Title("Bill");
        var t2 = new Title("Bensing");
        Assertions.assertFalse(t1.Equals(t2));
    }

}
