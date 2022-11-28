package io.bensing.kernel.values;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ContentTests {

    @Test
    @Tag("Small")
    @DisplayName("Successfully create a content block.")
    public void InstantiateContent() {
        var content = new Content("This is a block of content.\n This is the best block of content ever.\r Does This Work?");
        var expectedValue = "This is a block of content.\n This is the best block of content ever.\r Does This Work?";
        Assertions.assertEquals(expectedValue, content.Value());
    }

    @Test
    @Tag("Small")
    @DisplayName("Leading & Trailing spaces removed from content block")
    public void NoLeadingAndTrailingSpaces() {
        var content = new Content("  There are leading spaces.\n\r There are also trailing spaces.   ");
        var expectedValue = "There are leading spaces.\n\r There are also trailing spaces.";
        Assertions.assertEquals(expectedValue, content.Value());
    }

    @Test
    @Tag("Small")
    @DisplayName("Leading & Trailing returns removed from content block.")
    public void NoLeadingAndTrailingReturns() {
        var content = new Content("\nThere are leading spaces.\n\r There are also trailing spaces.\r");
        var expectedValue = "There are leading spaces.\n\r There are also trailing spaces.";
        Assertions.assertEquals(expectedValue, content.Value());
    }
}
