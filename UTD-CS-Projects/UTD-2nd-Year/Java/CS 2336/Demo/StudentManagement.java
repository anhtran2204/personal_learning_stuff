package Demo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class StudentManagement {
    public static void main(String[] args) {
        // Ask the user for the number of students in the system
        int numberOfStudents = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of students in the system: "));
        ArrayList<Student> students = new ArrayList<>();

        JOptionPane.showMessageDialog(null, "Welcome to the Student Management System");

        int menuChoice;

        do {
            String menuInput = JOptionPane.showInputDialog(null,
                    """
                            1 - Press 1 to add student
                            2 - Press 2 to deactivate a student
                            3 - Press 3 to display all students
                            4 - Press 4 to search for a student by ID
                            0 - Press 0 to exit the system
                            """);

            menuChoice = Integer.parseInt(menuInput);

            switch (menuChoice) {
                case 1: // add student
                    // Add students to the system with random IDs
                    int id = generateRandomStudentID(); // Assign a random ID
                    String firstName = JOptionPane.showInputDialog(null, "Enter Student First Name: ");
                    String lastName = JOptionPane.showInputDialog(null, "Enter Student Last Name: ");
                    students.add(new Student(id, firstName, lastName));
                    JOptionPane.showMessageDialog(null, "Student has been added");
                    break;

                case 2: // deactivate a student
                    int idToDeactivate = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Student ID to Deactivate: "));
                    if (searchStudentByID(students, idToDeactivate) != null) {
                        deactivateStudent(students, idToDeactivate);
                        JOptionPane.showMessageDialog(null, "Student has been deactivated");
                    }
                    break;

                case 3: // display all students in descending order by first name
                    displayAllStudentsDescending(students);
                    break;

                case 4: // search for a student by ID
                    double idToSearch = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Student ID To search: "));
                    searchStudentByID(students, idToSearch);
                    break;

                case 0: // exit the system
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid input, please try again");
                    break;
            }
        } while (menuChoice != 0);
    }

    private static void deactivateStudent(ArrayList<Student> students, double idToDeactivate) {
        for (Student student : students) {
            if (student.getID() == idToDeactivate) {
                student.deactivate();
                JOptionPane.showMessageDialog(null, "Student with ID " + idToDeactivate + " deactivated.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Student with ID " + idToDeactivate + " not found.");
    }

    private static void displayAllStudentsDescending(ArrayList<Student> students) {
        Collections.sort(students, Comparator.comparing(Student::getFirstName).reversed());
        StringBuilder message = new StringBuilder("List of Students (Descending Order by First Name):\n");
        for (Student student : students) {
            message.append(student.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, message.toString());
    }

    private static Student searchStudentByID(ArrayList<Student> students, double idToSearch) {
        for (Student student : students) {
            if (student.getID() == idToSearch) {
                JOptionPane.showMessageDialog(null, "Student Found:\n" + student.toString());
                return student;
            }
        }
        JOptionPane.showMessageDialog(null, "Student with ID " + idToSearch + " not found.");
        return null;
    }

    // Method to generate a random student ID in the range from 0 to 99
    private static int generateRandomStudentID() {
        Random random = new Random();
        return random.nextInt(101);
    }
}

// student class
class Student {
    private int id;
    private String firstName;
    private String lastName;
    private boolean active;

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = true; // By default, a student is active
    }

    public int getID() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void deactivate() {
        this.active = false;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + firstName + " " + lastName + ", Active: " + (active ? "Yes" : "No");
    }
}