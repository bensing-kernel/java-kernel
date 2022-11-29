package io.bensing.kernel.values;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class PersonTests {

    @Test
    @Tag("Small")
    @DisplayName("Successfully instantiate person")
    public void InstantiatePerson() {
        var person = new Person("Bill", "Bensing");

        Assertions.assertEquals(person.GivenName(), "Bill");
        Assertions.assertEquals(person.Surname(), "Bensing");
    }

    @Test
    @Tag("Small")
    @DisplayName("Successfully retrieve full name of the person")
    public void GetFullName() {
        var person = new Person("Bill", "Bensing");

        Assertions.assertEquals(person.FullName(), "Bill Bensing");
    }

    @Test
    @Tag("Small")
    @DisplayName("Two (2) of the same Persons equal.")
    public void PersonsEqual() {
        var p1 = new Person("First", "Person");
        var p2 = new Person("First", "Person");
        Assertions.assertTrue(p1.Equals(p2));
    }

    @Test
    @Tag("Small")
    @DisplayName("Two (2) differing Persons do not equal.")
    public void PersonsDoNotEqual() {
        var p1 = new Person("First", "Person");
        var p2 = new Person("Second", "Person");
        Assertions.assertFalse(p1.Equals(p2));
    }

}
