package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean first = true;

        for (int i = 0; i <=0; i++) {
            System.out.println("Enter the number: ");
            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {
                int number = scanner.nextInt();
                
                if (number > max) {
                    max = number;
                }

                if (number < min) {
                    min = number;
                }
                i--;
            } else {
                System.out.println("Invalid Number");
                break;
            }
            scanner.nextLine();
        }
        System.out.println("The min is " + min + " and the max is " + max);
        scanner.close();
    }
}
