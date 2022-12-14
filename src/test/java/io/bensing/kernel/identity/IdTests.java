package io.bensing.kernel.identity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class IdTests {

    @Test
    @Tag("small")
    @DisplayName("Create an Id object.")
    public void CreateId() {

        var id = new Id(1234123234);
        Assertions.assertEquals(1234123234, id.Value());
    }

    @Test
    @Tag("small")
    @DisplayName("Two of the same Id objects are equal.")
    public void SameIdsEqual() {

        var id1 = new Id(1234123234);
        var id2 = new Id(1234123234);

        Assertions.assertTrue(id1.Equals(id2));
    }

    @Test
    @Tag("small")
    @DisplayName("Two different Id objects are not equal.")
    public void DifferentIdsDoNotEqual() {

        var id1 = new Id(123412);
        var id2 = new Id(1234123234);

        Assertions.assertFalse(id1.Equals(id2));
    }
}
