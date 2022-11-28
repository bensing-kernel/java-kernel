package io.bensing.kernel.values;

public class Person {

    private final Title givenName;
    private final Title surname;

    public Person(String givenName, String surname) {
        this.givenName = new Title(givenName);
        this.surname = new Title(surname);
    }

    public String GivenName() {
        return this.givenName.Value();
    }

    public String Surname() {
        return this.surname.Value();
    }

    public String FullName() {
        return this.GivenName() + " " + this.Surname();
    }

}
