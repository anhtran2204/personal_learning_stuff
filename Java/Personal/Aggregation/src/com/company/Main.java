package com.company;

public class Main {

    public static void main(String[] args) {
        Instructor myInstructor =
                new Instructor("Tran", "Anh", "KS2204");

        Textbook myTextbook =
                new Textbook("Starting Out with Java", "Gaddis", "Addison-Wesley");

        Course myCourse = new Course("Introduction to Java", myInstructor, myTextbook);

        System.out.println(myCourse);
    }
}
