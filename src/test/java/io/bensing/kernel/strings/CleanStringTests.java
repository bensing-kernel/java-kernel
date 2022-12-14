package io.bensing.kernel.strings;

import io.bensing.kernel.strings.CleanString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CleanStringTests {

    @Test
    @Tag("Small")
    @DisplayName("Successfully clean string by removing the leading and trailing spaces.")
    public void TrimmedString_HappyPath() {
        var string = new CleanString(" Bill ");
        Assertions.assertEquals("Bill", string.toString());
    }

    @Test
    @Tag("Small")
    @DisplayName("Convert null input string into an empty string.")
    public void ConvertNullToEmptyString() {
        var string = new CleanString(null);
        Assertions.assertEquals("", string.toString());
    }

    @Test
    @Tag("Small")
    @DisplayName("Preserve return Characters")
    public void PreserveReturnCharacters() {
        var string = new CleanString(" This String\n Must Preserve\r Carriage & New Line\n\r returns.  ");
        var expectedValue = "This String\n Must Preserve\r Carriage & New Line\n\r returns.";
        Assertions.assertEquals(expectedValue, string.toString());
    }
}
