package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the position of the prime number: ");
        boolean hasNextInt = scanner.hasNextInt();

        int number = 0;
        if (hasNextInt) {
             number = scanner.nextInt();
        }
        System.out.println(getPosition(number));
    }

    public static boolean isPrime(int number) {
        if (number == 2) {                              // This makes it return the number immediately
            return true;                                // bc 2 is the only even prime number.
        }

        if (number < 2 || number % 2 == 0) {            // The second condition is bc any even numbers
            return false;                               // other than 2 aren't prime numbers.
        }

        for (int i = 3; i*i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        } return true;
    }

    public static int getPosition(int number) {
        int index = 0;
//        for (int i = 2; i <= number; i++) {           // This is used to do the opposite thing
//            if (!isPrime(i)) {                        // which is to tell the position given the
//                continue;                             // prime number.
//            }
//            index++;
//        }
//        return index;

        for(int i = 1; ; i++) {
            if(isPrime(i)) {
                index++;
            }

            if(index == number) {
                return i;
            }
        }
    }
}
