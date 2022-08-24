package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of digits: ");
        boolean hasNextInt = scanner.hasNextInt();
        int n = scanner.nextInt();

         if (hasNextInt) {
             System.out.println(getPalindromeProduct(n));
         }

    }

    public static int getPalindromeProduct(int n) {
        int upperLimit = 0;

        // Loop to calculate upper bound
        // (largest number of n-digit)

        for (int i = 1; i <= n; i++) {
            upperLimit *= 10;
            upperLimit += 9;
        }
        System.out.println("Upper limit is " + upperLimit);

        // largest number of n-1 digit.
        // One plus this number
        // is lower limit which is
        // product of two numbers.
        int lowerLimit = 1 + upperLimit / 10;
        System.out.println("Lower limit is " + lowerLimit);
        int maxProduct = 0;

        for (int i = upperLimit; i >= lowerLimit; i--) {
            for (int j = i; j >= lowerLimit ; j--) {
                int product = i * j;
                if (product < maxProduct) {
                    break;
                }
                int number = product;
                int reverse = 0;

                while (number != 0)
                {
                    reverse = reverse * 10 + number % 10;
                    number /= 10;
                }

                if (product == reverse && product > maxProduct) {
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }
}
