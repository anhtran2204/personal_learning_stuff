import java.util.Scanner;
import java.io.*;

public class AltWordPuzzle {

    //matrix[][] contains the input matrix
    //whenever a word is found in matrix[][],
    //copy the word to output[][]
    public static char[][] matrix, output;
    public static boolean[][] visited;

    // WRITE YOUR CODE HERE
    public static boolean searchBoard(char[] word, int letterIndex, int row, int col) {
        if (letterIndex == word.length) {
            return true;
        }
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length
                || matrix[row][col] != word[letterIndex] || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
//        if (rowDir != start || colDir ! start) {
//
//        }
        if (
                searchBoard(word, letterIndex + 1, row, col + 1) ||
                        searchBoard(word, letterIndex + 1, row, col - 1) ||
                        searchBoard(word, letterIndex + 1, row + 1, col) ||
                        searchBoard(word, letterIndex + 1, row - 1, col) ||
                        searchBoard(word, letterIndex + 1, row + 1, col + 1) ||
                        searchBoard(word, letterIndex + 1, row - 1, col - 1) ||
                        searchBoard(word, letterIndex + 1, row - 1, col + 1) ||
                        searchBoard(word, letterIndex + 1, row + 1, col - 1)) {
            output[row][col] = matrix[row][col];
            return true;
        }
        visited[row][col] = false;
        return false;
    }

    //search the word in all 8 directions from each position!
    public static void findWord(String word) {
// WRITE YOUR CODE HERE
        char[] wordToFind = word.toCharArray();
        visited = new boolean[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wordToFind[0]) {
                    searchBoard(wordToFind, 0, row, col);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        //let us use command line argument for input filename.
         File inputFile = new File("WordPuzzle/src/inputs/puzzle.txt").getAbsoluteFile();
//        File inputFile = new File(args[0]);
        Scanner finput = new Scanner(inputFile);

        int matrixSize = finput.nextInt();
        matrix = new char[matrixSize][matrixSize];
        output = new char[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = finput.next().charAt(0);
                // System.out.print(matrix[i][j] + " ");
                output[i][j] = ' ';
            }
            // System.out.println();
        }

        //read the words and find them in matrix!
        int numWords = finput.nextInt();
        for (int i = 0; i < numWords; i++) {
            String word = finput.next();
            // System.out.println(word);
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
