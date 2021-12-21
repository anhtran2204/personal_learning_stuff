package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.printf("%.5f", estimatePi(1000000));
    }

    public static double estimatePi(int points) {
        int pointsInCircle = 0;
        int pointsTotal = 0;

        for (int i = 0; i < points; i++) {
            double x = Math.random();
            double y = Math.random();
            if (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= 1) {
                pointsInCircle += 1;
            }
            pointsTotal += 1;
        }
        return (double) 4 * pointsInCircle / pointsTotal;
    }
}
