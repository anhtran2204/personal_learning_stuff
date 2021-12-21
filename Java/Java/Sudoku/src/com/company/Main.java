package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        generateBlankGrid();
    }

    public static void generateBlankGrid() {
        Random rand = new Random();
        int[] array = {1,2,3,4,5,6,7,8,9};
        int num = array[rand.nextInt(array.length)];
        int[][] sudoku = { {1,2,3}, {1,2,3}, {1,2,3}, {1,2,3}, {1,2,3}, {1,2,3}, {1,2,3}, {1,2,3}, {1,2,3} };

        System.out.println("+-----------------------+");
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                if ((i == 0 || i == 3 || i == 6) && j == 0) {
                    System.out.print("| " + sudoku[i][j] + " ");
                }
                else {
                    System.out.print(sudoku[i][j] + " ");
                }
                if (j == 2) {
                    System.out.print("| ");
                }

            }
            if (i == 2 || i == 5) {
                System.out.println("");
                System.out.println("+ ----- + ----- + ----- +");
            }
        }
        System.out.println("\n+-----------------------+");
    }
}
