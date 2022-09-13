import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class WordPuzzle {

    //matrix[][] contains the input matrix
    //whenever a word is found in matrix[][],
    //copy the word to output[][]
    public static char[][] matrix, output;

    // WRITE YOUR CODE HERE
    final static int[][] dirOffsets = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
            {1, 1},
            {-1, -1},
            {-1, 1},
            {1, -1}
    };

    public static void searchBoard(char[] word, int letterIndex, int row, int col) {
        if (row < 0 || row > matrix.length - 1 || col < 0 || col > matrix.length - 1) {
            return;
        }

        if (letterIndex > word.length - 1) {
            return;
        }

        if (matrix[row][col] == word[letterIndex]) {
            searchBoard(word, letterIndex + 1, row, col + 1);
            searchBoard(word, letterIndex + 1, row, col - 1);
            searchBoard(word, letterIndex + 1, row + 1, col);
            searchBoard(word, letterIndex + 1, row - 1, col + 1);
            searchBoard(word, letterIndex + 1, row + 1, col + 1);
            searchBoard(word, letterIndex + 1, row - 1, col - 1);
            searchBoard(word, letterIndex + 1, row - 1, col + 1);
            searchBoard(word, letterIndex + 1, row + 1, col - 1);
            output[row][col] = word[letterIndex];
        }
    }

    //search the word in all 8 directions from each position!
    public static void findWord(String word) {
// WRITE YOUR CODE HERE
        char[] wordToFind = word.toCharArray();
        int letterIndex = 0;
        String temp = "";
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                searchBoard(wordToFind, letterIndex, row, col);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        //let us use command line argument for input filename.
        System.out.println();
        File inputFile = new File("WordPuzzle/src/inputs/puzzle.txt").getAbsoluteFile();
        Scanner finput = new Scanner(inputFile);

        int matrixSize = finput.nextInt();
        matrix = new char [matrixSize][matrixSize];
        output = new char [matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = finput.next().charAt(0);
                System.out.print(matrix[i][j] + " ");
                output[i][j] = ' ';
            }
            System.out.println();
        }

        //read the words and find them in matrix!
        int numWords = finput.nextInt();
        for (int i = 0; i < numWords; i++) {
            String word = finput.next();
            System.out.println(word);
            findWord(word);
        }

        //output the words in matrix format
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++)
                System.out.print(output[i][j] + " ");
            System.out.println();
        }
    }
}
