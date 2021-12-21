package com.company;

public class Sudoku {
	private static int[][] board = {
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0},
	};

    public static void main(String[] args) {
        generateBoard();
    }

    public static void generateBoard() {
    	String line = "-".repeat(25);
    	for (int i = 0; i < board.length; i++) {
    		if (i % 3 == 0) {
    			System.out.println(line);
    		}
    		String row_to_print = "";
			for (int j = 0; j < board[i].length; j++) {
				if (j % 3 == 0) {
					row_to_print += "| ";
				}
				
				String value;
				if (board[i][j] > 0) {
					value = Integer.toString(board[i][j]);
				} else {
					value = " ";
				}
				row_to_print += value + " ";
			}
			row_to_print += "|";
			System.out.println(row_to_print);
		}
    	System.out.println(line);
    }
}
