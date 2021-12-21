package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPage = 0;

        Printer printer = new Printer(100, numOfPage, true, true);

        printer.turnOn();

        System.out.println("Enter initial number of pages printed: ");
        boolean hasNextInt = scanner.hasNextInt();
        if (hasNextInt) {
            numOfPage = scanner.nextInt();
            System.out.println("There are " + numOfPage + " pages already printed.");
        }

        scanner.nextLine();

        System.out.println("Enter number of pages to print: ");
        int amount = scanner.nextInt();
        printer.addNumOfPages(amount);
        System.out.println("Total pages printed: " + Math.addExact(numOfPage, amount));

        int inkLost = scanner.nextInt();
        printer.loseTonerLevel(inkLost);

        int addInk = scanner.nextInt();
        printer.addTonerLevel(addInk);
    }
}
