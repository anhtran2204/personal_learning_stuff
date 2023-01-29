package SwipingSuggestions.src;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class SwipingSuggestions {
    static final int NUMCHARS = 26;
    static String options[];
    static String words[];
    static String inputWord;

    // WRITE YOUR CODE HERE
    public static void findOptions(int nextIndex, String partialWord) {
        if (partialWord.length() == inputWord.length()) {
            int index = Arrays.binarySearch(words, partialWord);
            if (index >= 0) {
                if (words[index].equals(partialWord)) {
                    System.out.print(words[index] + " ");
                }
            }
            return;
        }

//        for (int i = 0; i < options[nextIndex].length(); i++) {
//            char optionChar = options[nextIndex].charAt(i);
//            findOptions(nextIndex+1, partialWord+optionChar);
//        }


        for (String option : options) {
            if (option.charAt(0) == inputWord.charAt(nextIndex)) {
                for (int j = 0; j < option.length(); j++) {
                    findOptions(nextIndex + 1, partialWord + option.charAt(j));
                }
            }
        }
    }

    public static void main (String[]args) throws FileNotFoundException {
        Scanner dictionaryInput = new Scanner(new File("words.txt"));

        int numWords = 0;
        while (dictionaryInput.hasNextLine()) {
            dictionaryInput.nextLine();
            numWords++;
        }
        dictionaryInput.close();

        words = new String[numWords];
        dictionaryInput = new Scanner(new File("words.txt"));
        for (int i = 0; i < numWords; i++)
            words[i] = dictionaryInput.nextLine();
        dictionaryInput.close();

        Scanner optionsInput = new Scanner(new File("options.txt"));
        options = new String[NUMCHARS];
        for (int i = 0; i < NUMCHARS; i++) {
            options[i] = optionsInput.nextLine();
        }

        Scanner input = new Scanner(System.in);
        inputWord = input.next();

        findOptions(0, "");
// WRITE YOUR CODE HERE
    }
}

