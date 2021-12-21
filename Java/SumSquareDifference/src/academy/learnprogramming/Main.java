package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of natural numbers: ");
        boolean hasNextInt = scanner.hasNextInt();

        int n = 0;
        if (hasNextInt) {
            n = scanner.nextInt();
        }

        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += Math.pow(i, 2);
        }
        System.out.println("The sum of squares of first n natural numbers: " + sum);

        int newSum = 0;
        for (int i = 0; i <= n; i++) {
            newSum += i;
        }
        int sqreSum = (int) Math.pow(newSum, 2);
        System.out.println("The square of the sum of first n natural numbers: " + sqreSum);

        int difference = sqreSum - sum;
        System.out.println("The difference between the two is: " + difference);
    }
}
