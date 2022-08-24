package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }

    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        long average = 0;
        int counter = 0;

        for (int i = 0; i <= 0; i++) {
            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {
                int number = scanner.nextInt();
                sum += number;
                counter++;
                i--;
            } else {
                break;
            }
            scanner.nextLine();
        }
        average = (long) Math.round((double) sum / counter);
        System.out.println("SUM = " + sum + " AVG = " + average);
        scanner.close();
    }
}
