package io.bensing.kernel;

public class Person {

    private final Name givenName;
    private final Name surname;

    Person(String givenName, String surname) {
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
