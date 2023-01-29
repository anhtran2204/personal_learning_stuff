package NQueens.src;

import java.util.Scanner;

public class NQueens {
    //n * n board to place queens:
    // 'Q' indicates Queen is present in that position, ' ' indicates NO queen
    public static char board[][];
    public static int QUEENS;
    public static int solutionCount = 0;

    //check this position is SAFE based on all previous rows' queen placements?
    public static boolean okToPlace(int row, int column) {
// WRITE YOUR CODE HERE
        if (row < 0 || row > board.length - 1 || column < 0 || column > board.length - 1) {
            return false;
        }

        if (board[row][column] != ' ') {
            return false;
        }

        // Right, left, and right down
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != ' ') {
                return false;
            }

            if (board[i][column] != ' ') {
                return false;
            }
        }

        int i = row, j = column;
        // Top left
        while (0 <= i && 0 <= j) {
            if (board[i][j] != ' ')
                return false;
            i--;
            j--;
        }

        // Top right
        i = row;
        j = column;
        while (0 <= i && j < board.length) {
            if (board[i][j] != ' ')
                return false;
            i--;
            j++;
        }
        // Down Right
        i = row;
        j = column;
        while (i < board.length && j < board.length) {
            if (board[i][j] != ' ')
                return false;
            i++;
            j++;
        }
        // Down left
        i = row;
        j = column;
        while (i < board.length && 0 <= j) {
            if (board[i][j] != ' ')
                return false;
            i++;
            j--;
        }
        return true;
    }

    // recurisve function to place queens
    // increment solutionCount for each complete configuration
    public static void placeQueens(int row) {
        if (QUEENS == 0) {
            solutionCount++;
            return;
        }
// WRITE YOUR CODE HERE

        for (int col = 0; col < board.length; col++) {
            if (okToPlace(row, col)) {
                board[row][col] = 'Q';
                QUEENS--;
                placeQueens(row+1);
                board[row][col] = ' ';
                QUEENS++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //get the board size & initialize the board
        int boardSize = input.nextInt();
        board = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++)
            for (int j = 0; j < boardSize; j++)
                board[i][j] = ' ';

        // start with the first row & count # of valid configurations.
        QUEENS = board.length;
        placeQueens(0);
        System.out.println(solutionCount);
    }
}

