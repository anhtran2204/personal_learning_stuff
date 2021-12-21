package com.company;

public class Course {
    private String courseName;
    private Instructor instructor;
    private Textbook textbook;

    public Course(String courseName, Instructor instructor, Textbook textbook) {
        this.courseName = courseName;
        this.instructor = new Instructor(instructor);
        this.textbook = new Textbook(textbook);
    }

    public String getCourseName() {
        return courseName;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public Textbook getTextbook() {
        return textbook;
    }

    @Override
    public String toString() {
        return "Course name: " + courseName
                + "\n\nInstructor Information:\n" + instructor
                + "\n\nTextbook Information:\n" + textbook;
    }
}
