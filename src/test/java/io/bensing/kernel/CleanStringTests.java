package io.bensing.kernel;

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
        Assertions.assertEquals(string.getValue(), "Bill");
    }

    @Test
    @Tag("Small")
    @DisplayName("Convert null input string into an empty string.")
    public void ConvertNullToEmptyString() {
        var string = new CleanString(null);
        Assertions.assertEquals(string.getValue(), "");
    }
}
