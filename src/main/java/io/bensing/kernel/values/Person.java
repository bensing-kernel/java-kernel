package io.bensing.kernel.values;

public class Person {

    private final Title givenName;
    private final Title surname;

    public Person(String givenName, String surname) {
        this.givenName = new Title(givenName);
        this.surname = new Title(surname);
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
