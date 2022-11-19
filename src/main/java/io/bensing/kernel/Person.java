package io.bensing.kernel;

public class Person {

    private Name givenName;
    private Name surname;

    Person(String givenName, String surname) {
        this.givenName = new Name(givenName);
        this.surname = new Name(surname);
    }

    public String getGivenName() {
        return this.givenName.getValue();
    }

    public String getSurname() {
        return this.surname.getValue();
    }

    public String getFullName() {
        return this.getGivenName() + " " + this.getSurname();
    }

}
