import java.util.Scanner;
import java.io.*;

public class WordPuzzle {

    //matrix[][] contains the input matrix
    //whenever a word is found in matrix[][],
    //copy the word to output[][]
    public static char matrix[][], output[][];

    // WRITE YOUR CODE HERE
    enum directions {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        TOP_TO_DOWN,
        DOWN_TO_TOP,
        RIGHT_DIAGONAL_DOWN,
        RIGHT_DIAGONAL_UP,
        LEFT_DIAGONAL_DOWN,
        LEFT_DIAGONAL_UP;
    }
    public static int currDir = directions.LEFT_TO_RIGHT.ordinal();
    public static int rowIndex = 0, colIndex = 0, letterIndex = 0;
    public static int currRow = 0, currCol = 0;
    public static boolean match = false;

    //search the word in all 8 directions from each position!
    public static void findWord(String word) {
// WRITE YOUR CODE HERE
        char[] wordToFind = word.toCharArray();

        if (wordToFind.length == 1 && wordToFind[letterIndex] == matrix[rowIndex][colIndex]) {
            match = true;
            return;
        }

        if (wordToFind[letterIndex] == matrix[rowIndex][colIndex]) {
            currCol++;
        } else {
            currDir++;
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
