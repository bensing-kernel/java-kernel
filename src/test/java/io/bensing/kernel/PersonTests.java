package io.bensing.kernel;

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

        Assertions.assertEquals(person.getGivenName(), "Bill");
        Assertions.assertEquals(person.getSurname(), "Bensing");
    }

    @Test
    @Tag("Small")
    @DisplayName("Successfully retrieve full name of the person")
    public void GetFullName() {
        var person = new Person("Bill", "Bensing");

        Assertions.assertEquals(person.getFullName(), "Bill Bensing");
    }

}
