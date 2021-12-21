package com.company;

public class ArraysAlgorithms {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int[] array = {5, 7, 2, 8, 9, 1};
        System.out.println(sequentialSearch(array, 2));
        System.out.println("" + runtime.freeMemory());;

        selectionSort(array);
        System.out.println(binarySearch(array, 2));
        System.out.println("" + runtime.freeMemory());;
    }

    /*
     * Comparing arrays
     */
    public static void compareArrays(int[] firstArray, int[] secondArray) {

        boolean isEqual = true; //Flag variable
        int index = 0; // Loop control variable

        // First compare the arrays' length
        if (firstArray.length != secondArray.length) {
            isEqual = false;
        }

        // Determine if each element of the arrays are equal
        while (isEqual && index < firstArray.length) {
            if (firstArray[index] != secondArray[index]) {
                isEqual = false;
            }
            index++;
        }

        // Confirm if the arrays are equal or not
        if (isEqual) {
            System.out.println("The arrays are the same.");
        }
        else {
            System.out.println("The arrays are not the same.");
        }
    }

    public static int sumValuesInArray(int[] array) {
        int total = 0;
        for (int j : array) {
            total += j;
        }
        return total;
    }

    public static double average(int[] array) {
        int total = 0;
        for (int j : array) {
            total += j;
        }
        return (double) total/array.length;
    }

    public static int getMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min < array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max > array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    public static int sequentialSearch(int[] array, int num) {
        for (int j : array) {
            if (j == num) {
                return j;
            }
        }
        return -1;
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            int temp = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < temp) {
                    temp = array[j];
                    minIndex = j;
                }
            }
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static int binarySearch(int[] array, int num) {
        int first = 0;
        int last = array.length - 1;
        int position = -1;
        boolean found = false;

        while (!found && first <= last) {
            int middle = (first + last)/2;

            if (array[middle] == num) {
                found = true;
                position = middle;
            }
            else if (array[middle] > num) {
                last = middle - 1;
            }
            else {
                first = middle + 1;
            }
        }
        return position;
    }
}
