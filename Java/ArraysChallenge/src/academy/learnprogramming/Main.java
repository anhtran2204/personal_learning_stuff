package academy.learnprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);
        int[] sorted = sortIntegers(myIntegers);
        printArray(sorted);
    }

    public static int[] getIntegers(int number) {
        int[] myIntegers = new int[number];
        System.out.println("Enter " + number + " integer values:\r");
        for (int i = 0; i < myIntegers.length; i++) {
            myIntegers[i] = scanner.nextInt();
        }
        return myIntegers;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array) {
        // copy an array to used as a new array

//        int[] sortedArray = new int[array.length];
        int[] sortedArray = Arrays.copyOf(array, array.length);
        System.out.println("The resorted array: ");
//        for (int i = 0; i < array.length; i++) {
//            sortedArray[i] = array[i];
//        }
        boolean flag = true;
        int temp;

        while (flag) {
            flag = false;

            // element 0 = 50
            // element 1 = 160
            // element 2 = 40
            // swap 1 into 0
            for (int i = 0; i < sortedArray.length-1; i++) {
                if (sortedArray[i] < sortedArray[i+1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }
}
