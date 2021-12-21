package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number: ");
        boolean hasNextInt = scanner.hasNextInt();

        if (hasNextInt) {
            int number = scanner.nextInt();
            System.out.println("The sum of the primes below " + number + " is: " + getSummation(number));
        }
    }

    public static boolean isPrime(int number) {
        if (number == 2) {
            return true;
        }

        if (number < 2 || number % 2 == 0) {
            return false;
        }

        for (int i = 3; i*i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long getSummation(int number) {
        long sum = 0;
        int counter = 0;
        for (int i = number - 1; i >= 2; i--) {
            if (isPrime(i)) {
                sum += i;
                counter++;
            }
        }
        System.out.println("The number of primes are " + counter);
        return sum;
    }
}
