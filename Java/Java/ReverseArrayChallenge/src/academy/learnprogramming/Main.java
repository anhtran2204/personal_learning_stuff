package academy.learnprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the number of elements:");
        int choice = scanner.nextInt();
        reverse(getIntegers(choice));
    }

    public static int[] getIntegers(int number) {
        int[] myArray = new int[number];

        System.out.println("Enter " + number + ", integer values:");
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = scanner.nextInt();
        }
        return myArray;
    }

    public static void reverse(int[] array) {
        int temp;
        int maxIndex = array.length-1;
        int halfLength = array.length/2;

        for (int i = 0; i < halfLength; i++) {
            temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }
        System.out.println("The reverse array is: " + Arrays.toString(array));
    }
}
