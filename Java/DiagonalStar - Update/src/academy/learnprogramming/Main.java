package academy.learnprogramming;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int num = scanner.nextInt();
        printSquare(num);
    }

    public static void printSquare(int number) {
        if (number < 1) {
            System.out.println("Invalid Value.");
        }

        for (int row = 1; row <= number; row++) {
            for (int column = 1; column <= number; column++) {
                if (row == 1 || row == number || row == column ||
                        column == 1 || column == number || row == number + 1 - column) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
    }
}
