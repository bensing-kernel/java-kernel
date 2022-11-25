package io.bensing.kernel.values;

import io.bensing.kernel.values.Name;

public class Person {

    private final Name givenName;
    private final Name surname;

    public Person(String givenName, String surname) {
        this.givenName = new Name(givenName);
        this.surname = new Name(surname);
    }

    public String getGivenName() {
        return this.givenName.toString();
    }

    public String getSurname() {
        return this.surname.toString();
    }

    public String getFullName() {
        return this.getGivenName() + " " + this.getSurname();
    }

}
