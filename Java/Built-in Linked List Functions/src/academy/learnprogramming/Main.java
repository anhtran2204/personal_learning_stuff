package academy.learnprogramming;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<Integer>();
        LinkedList<String> strings = new LinkedList<String>();
        LinkedList<Double> doubles = new LinkedList<Double>();

        System.out.println("Enter the number of loops:");
        int times = scanner.nextInt();
        System.out.println("Enter the integer:");
        for (int i = 0; i < times; i++) {
            int num = scanner.nextInt();
            appendInteger(integers, num);
        }

        traverse(integers);
    }

    public static boolean appendInteger(LinkedList<Integer> linkedList, int integer) {
        ListIterator<Integer> integerListIterator = linkedList.listIterator();
        while (integerListIterator.hasNext()) {
            int comparison = integerListIterator.next().compareTo(integer);
            if (comparison == 0) {
                System.out.println(integer + " is already added");
                return false;
            } else if (comparison > 0) {
                integerListIterator.previous();
                integerListIterator.add(integer);
                return true;
            }
        }
        integerListIterator.add(integer);
        return true;
    }

    public static void traverse(LinkedList linkedList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator listIterator = linkedList.listIterator();

        if (linkedList.isEmpty()) {
            System.out.println("\nNo cities in the itinerary");
        } else {
            System.out.println("\nNumber: " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Exit List!");
                    break;

                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Number: " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list.");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Number: " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list.");
                        goingForward = true;
                    }
                    break;

                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nAvailable actions:\nPress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next number\n" +
                "2 - go to previous number\n" +
                "3 - print menu options");
    }
}
