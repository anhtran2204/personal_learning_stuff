import java.util.Scanner;
import java.io.*;

public class WordPuzzle {

    //matrix[][] contains the input matrix
    //whenever a word is found in matrix[][],
    //copy the word to output[][]
    public static char matrix[][], output[][];

// WRITE YOUR CODE HERE

    //search the word in all 8 directions from each position!
    public static void findWord(String word) {
// WRITE YOUR CODE HERE
        char wordToFind[] = word.toCharArray();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (int k = j; k < matrix[i].length; k++) {

                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        //let us use command line argument for input filename.
        File inputFile = new File(args[0]);
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
