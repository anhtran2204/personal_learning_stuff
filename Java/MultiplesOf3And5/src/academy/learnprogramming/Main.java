package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number: ");
        boolean hasNextInt = scanner.hasNextInt();

        if (hasNextInt) {
            int number = scanner.nextInt();
            System.out.println("The sum of the multiples of 3 or 5 below " + number + " is: " + getMultiple(number));
        }
    }

    public static int getMultiple(int number) {
        int sum = 0;
        for (int i = number - 1; i > 0; i--) {
            if (i % 3 == 0 || i % 5 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
