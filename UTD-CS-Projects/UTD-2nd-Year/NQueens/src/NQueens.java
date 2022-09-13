package NQueens.src;


import java.util.Scanner;

public class NQueens {
    //n * n board to place queens:
    // 'Q' indicates Queen is present in that position, ' ' indicates NO queen
    public static char board[][];
    public static int solutionCount = 0;

    //check this position is SAFE based on all previous rows' queen placements?
    public static boolean okToPlace(int row, int column) {
// WRITE YOUR CODE HERE
        for(int i = 0; i < column; i++) {
            if (board[row][column] != ' ') {
                return false;
            }
        }

        for(int i = 0; i < row; i++) {

        }
    }

    // recurisve function to place queens
    // increment solutionCount for each complete configuration
    public static void placeQueens(int row) {
// WRITE YOUR CODE HERE

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
        placeQueens(0);
        System.out.println(solutionCount);
    }
}

