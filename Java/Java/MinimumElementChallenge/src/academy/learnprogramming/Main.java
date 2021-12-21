package academy.learnprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the number of elements.");
        int count = scanner.nextInt();
        int[] myArray = readIntegers(count);
        System.out.println("The array is: " + Arrays.toString(myArray));
        System.out.println("The minimum element of the array is: " + findMin(myArray));
    }

    public static int[] readIntegers(int count) {
        int[] myIntegers = new int[count];
        System.out.println("Enter " + count + " integer values:\r");
        for (int i = 0; i < myIntegers.length; i++) {
            myIntegers[i] = scanner.nextInt();
        }
        return myIntegers;
    }

    public static int findMin(int[] array) {
        int[] compareArray = Arrays.copyOf(array, array.length);

        boolean flag = true;
        int min = Integer.MAX_VALUE;

        while (flag) {
            flag = false;

            for (int i = 0; i < compareArray.length; i++) {
                if (min > compareArray[i]) {
                    min = compareArray[i];
                    flag = true;
                }
            }
        }
        return min;
    }
}
