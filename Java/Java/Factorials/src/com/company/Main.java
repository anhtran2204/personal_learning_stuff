package com.company;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final long startTime = System.nanoTime();

        System.out.println("Enter your number:");
        int num = scanner.nextInt();

        int factorialInt = 1;
        for (int i = 1; i <= num; i++) {
            factorialInt *= i;
        }
        BigInteger factorial = BigInteger.valueOf(factorialInt);
        System.out.println(factorialInt);

        final long duration = System.nanoTime() - startTime;
//        long convertDuration = TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS);
        double convertDuration = (double) duration / 1000000000;
        System.out.printf("Runtime: %s nanoseconds\nConvert to seconds: %.2f seconds", duration, convertDuration);

    }
}
