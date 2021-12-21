package academy.learnprogramming;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        System.out.println(calcCollatz(n));
    }

    public static int calcCollatz(int n) {
        int count = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (n*3) + 1;
            }
            count++;
        }
        return count;
    }
}
