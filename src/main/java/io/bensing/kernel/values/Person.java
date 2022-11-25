package io.bensing.kernel.values;

public class Person {

    private final Name givenName;
    private final Name surname;

    public Person(String givenName, String surname) {
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
