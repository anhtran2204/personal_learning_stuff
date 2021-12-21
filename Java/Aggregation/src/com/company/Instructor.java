package com.company;

public class Instructor {
    private String lastName;
    private String firstName;
    private String officeNumber;

    public Instructor(String lastName, String firstName, String officeNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.officeNumber = officeNumber;
    }

    public Instructor(Instructor instructor) {
        lastName = instructor.lastName;
        firstName = instructor.firstName;
        officeNumber = instructor.officeNumber;
    }

    public void set(String lastName, String firstName, String officeNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.officeNumber = officeNumber;
    }

    @Override
    public String toString() {
        return  "\tLast Name: " + lastName
                + "\n\tFirst Name: " + firstName
                + "\n\tOffice Number: " + officeNumber;
    }
}
