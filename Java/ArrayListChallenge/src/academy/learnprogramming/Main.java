package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();
    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printContactInstructions();
//        turnOn();
//        printPhoneMenu();
//        while (!quit) {
//            System.out.println("Enter your choice: ");
//            choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (choice) {
//                case 0:
//                    printPhoneMenu();
//                    break;
//
//                case 1:
//                    printContactInstructions();
//                    break;
//
//                case 2:
//                    printGamesMenu();
//                    break;
//
//                case 3:
//                    printCalculator();
//                    break;
//
//                case 4:
//                    printMusicMenu();
//                    break;
//
//                case 5:
//                    quit = true;
//                    break;
//            }
//        }
//
//        quit = false;
        while (!quit) {
            System.out.println("Enter your choice: ");
            boolean hasNextInt = scanner.hasNextInt();
            choice = scanner.nextInt();
            scanner.nextLine();
            if (hasNextInt) {
                switch (choice) {
                    case 0:
                        printContactInstructions();
                        break;

                    case 1:
                        mobilePhone.printContactList();
                        break;

                    case 2:
                        addContact();
                        break;

                    case 3:
                        modifyContact();
                        break;

                    case 4:
                        removeContact();
                        break;

                    case 5:
                        searchContact();
                        break;

                    case 6:
                        quit = true;
                        break;
                }
            }
        }
    }

    public static void turnOn() {
        System.out.println("Turning on phone.....");
    }

    public static void printPhoneMenu() {
        System.out.println("========= WELCOME BACK =========");
        System.out.println("\n~ What would you like to do?");
        System.out.println("\t 1. Access your contacts.");
        System.out.println("\t 2. Play some games.");
        System.out.println("\t 3. Access your calculator.");
        System.out.println("\t 4. Play some music.\n");
    }

    public static void printContactInstructions() {
        System.out.println("\nPress");
        System.out.println("\t 0 - To print contact choice options.");
        System.out.println("\t 1 - To print the list of contacts.");
        System.out.println("\t 2 - To add a contact to the list.");
        System.out.println("\t 3 - To modify a contact in the list.");
        System.out.println("\t 4 - To remove a contact from the list.");
        System.out.println("\t 5 - To search for a contact in the list.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addContact() {
        System.out.println("Enter name of new contact:");
        String name = scanner.nextLine();
        System.out.println("Enter number of new contact:");
        String number = scanner.nextLine();
        Contact newContact = new Contact(name,number);

        mobilePhone.addContact(newContact);
        mobilePhone.sortContact(newContact);
    }

    public static void modifyContact() {
        System.out.println("Enter name of contact to be modified:");
        String name = scanner.nextLine();
        Contact original = mobilePhone.existingContact(name);
        if(original == null) {
            System.out.println("Contact with this name not found.");
            return;
        }

        System.out.println("Enter new name:");
        String newName = scanner.nextLine();
        System.out.println("Enter new number:");
        String newNumber = scanner.nextLine();
        Contact newContact = new Contact(newName,newNumber);

        mobilePhone.modify(original, newContact);
    }

    public static void removeContact() {
        System.out.println("Enter name of contact to be removed:");
        String name = scanner.nextLine();
        Contact contact = mobilePhone.existingContact(name);

        mobilePhone.remove(contact);
    }

    public static void searchContact() {
        System.out.println("Enter name of contact to look for:");
        String name = scanner.nextLine();
        Contact contact = mobilePhone.existingContact(name);

        if(contact == null) {
            System.out.println("No contact found with this name.\n");
        }
        else {
            System.out.println(contact.getName() + "'s number is " + contact.getPhoneNumber() + "\n");
        }
    }
}
