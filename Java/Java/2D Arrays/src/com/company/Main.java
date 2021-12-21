package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] lotteryCard = {{20, 15, 7}, {8, 7, 19}, {7, 13, 47}};


    }

    public static void display(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int sum(int[][] array) {
        int total = 0;

        for (int[] ints : array) {
            for (int anInt : ints) {
                total += anInt;
            }
        }
        return total;
    }
}
