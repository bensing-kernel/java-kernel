package io.bensing.kernel.values;

import io.bensing.kernel.interfaces.Comparable;

public class Person implements Comparable<Person> {

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

    public boolean Equals(Person person) {
        var sameGiven = this.givenName.Value() == person.GivenName();
        var sameSurname = this.surname.Value() == person.Surname();
        return sameSurname && sameGiven;
    }
}
