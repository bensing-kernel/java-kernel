package io.bensing.kernel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TrimmedStringTests {

    @Test
    @Tag("Small")
    @DisplayName("Successfully Trim String")
    public void TrimmedString_HappyPath() {
        var trimmedString = new TrimmedString(" Bill ");
        Assertions.assertEquals(trimmedString.getValue(), "Bill");
    }
}
