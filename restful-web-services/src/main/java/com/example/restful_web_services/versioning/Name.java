package com.example.restful_web_services.versioning;

public class Name {

    private String lastName;
    private String firstName;

    public Name(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Name{" +
            "lastName='" + lastName + '\'' +
            ", firstName='" + firstName + '\'' +
            '}';
    }
}
