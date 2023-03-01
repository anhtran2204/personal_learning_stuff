package HorseShoe;

import java.util.*;
import java.io.*;

class hshoe {
    static char matrix[][];
    static int size = 0;
    static int maxLength = 0;

    public static void findMatchingClose(int length, int row, int column, int maxOpen) {
        if (length == maxOpen && maxLength < 2*length) {
            maxOpen = 2*length;
            return;
        }

        if (row < 0 || row > size || column < 0 || column > size) {
            return;
        }

        if (matrix[row][column] != ')'){
            return;
        }
        matrix[row][column] = '.';
        findMaxOpen(length+1,row,column+1);
        findMaxOpen(length+1,row,column-1);
        findMaxOpen(length+1,row+1,column);
        findMaxOpen(length+1,row-1,column);
        matrix[row][column] = ')';
    }

    public static void findMaxOpen(int length, int row, int column) {
        if (length > maxLength) {
            maxLength = length;
        }

        if (row < 0 || row > size || column < 0 || column > size) {
            return;
        }

        if (matrix[row][column] != '.') {
            return;
        }

        if (matrix[row][column] != ')') {
            findMatchingClose(0, row, column, length);
        }
        matrix[row][column] = '.';
        findMaxOpen(length+1,row,column+1);
        findMaxOpen(length+1,row,column-1);
        findMaxOpen(length+1,row+1,column);
        findMaxOpen(length+1,row-1,column);
        matrix[row][column] = '(';
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File("hshoe.in"));
        PrintWriter output = new PrintWriter("hshoe.out");

        size = input.nextInt();
        matrix = new char [size][];
        for(int i=0; i<size; i++) {
            String line = input.next();
            matrix[i] = line.toCharArray();
            //one line version: matrix[i] = input.next().toCharArray();
        }

        //now we can access individual character as matrix[i][j]

        output.println(maxLength);
        output.close();
    }
}
