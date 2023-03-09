import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortTest {
    private static Scanner kb = new Scanner(System.in);

    // Array that contains the necessary data types
    private static final String[] dataTypes = { "InOrder", "ReverseOrder", "AlmostOrder", "Random Order" };
    // Array that contains the input sizes to choose
    private static final int[] inputSizes = { 500, 15000, 50000 };
    // Array that contains choices of sorting algorithms
    private static final String[] sortAlgos = {
            "Insertion Sort", "Selection Sort", "Quick Sort",
            "Merge Sort", "Heap Sort", "Radix Sort"
    };

    private static int[] array; // Declared the array that we are using

    public static void main(String[] args) {
        // Enter choice of data types
        print(dataTypes);
        System.out.print("List Properties, select the data type of list you wish to use: ");
        int dataTypeChoice = kb.nextInt();
        System.out.println();

        // Enter choice of input size
        print(inputSizes);
        System.out.print("Input Size, select the size of list: ");
        int SIZE = kb.nextInt();
        array = new int[inputSizes[SIZE-1]];

        // Creating the array based on the data types
        Random random = new Random();
        switch (dataTypeChoice) {
            case 1: // Sorted
                for (int i = 0; i < array.length; i++) {
                    array[i] = i;
                }
                break;

            case 2: // Reverse sorted
                for (int i = 0; i < array.length; i++) {
                    array[i] = array.length - i - 1;
                }
                break;

            case 3: // Almost sorted
                int flag = (int) (array.length * 0.8);
                for (int i = 0; i < flag; i++) {
                    array[i] = i;
                }

                for (int i = flag; i < array.length; i++) {
                    array[i] = random.nextInt(array.length);
                }

            case 4: // Random
                for (int i = 0; i < array.length; i++) {
                    array[i] = random.nextInt(array.length);
                }
                break;
        }
        System.out.println();

        // Enter choice of sorting algorithms
        print(sortAlgos);
        System.out.print("Sorting Algorithm, select the sorting algorithm: ");
        int algoChoice = kb.nextInt();
        result(algoChoice, dataTypes[dataTypeChoice - 1]);
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i+1 + ". " + array[i]);
        }
    }

    public static void print(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i+1 + ". " + array[i]);
        }
    }

    // Print result based on the type of sorting algorithms
    // which includes comparisons, movements of elements,
    // and running time of the methods.
    public static void result(int sortAlgo, String dataType) {
        System.out.println();
        int comparisons = 0;
        int movements = 0;
        int runningTime = 0;

        // Each case get the comparisons,
        // movements, and running time
        // from each class that contains
        // the algorithms.
        switch (sortAlgo) {
            case 1:
                InsertionSort.insertionSort(array);
                comparisons = InsertionSort.getComparisons();
                movements = InsertionSort.getMovements();
                runningTime = InsertionSort.getRunningTime();
                InsertionSort.setComparisons(0);
                InsertionSort.setMovements(0);
                break;

            case 2:
                SelectionSort.selectionSort(array);
                comparisons = SelectionSort.getComparisons();
                movements = SelectionSort.getMovements();
                runningTime = SelectionSort.getRunningTime();
                SelectionSort.setComparisons(0);
                SelectionSort.setMovements(0);
                break;

            case 3:
                QuickSort.quickSort(array);
                comparisons = QuickSort.getComparisons();
                movements = QuickSort.getMovements();
                runningTime = QuickSort.getRunningTime();
                QuickSort.setComparisons(0);
                QuickSort.setMovements(0);
                break;

            case 4:
                MergeSort.mergeSort(array);
                comparisons = MergeSort.getComparisons();
                movements = MergeSort.getMovements();
                runningTime = MergeSort.getRunningTime();
                MergeSort.setComparisons(0);
                MergeSort.setMovements(0);
                break;

            case 5:
                Integer[] newArray = new Integer[array.length];
                for (int i = 0; i < array.length; i++) {
                    newArray[i] = array[i];
                }
                HeapSort.heapSort(newArray);
                comparisons = HeapSort.getComparisons();
                movements = HeapSort.getMovements();
                runningTime = HeapSort.getRunningTime();
                HeapSort.setComparisons(0);
                HeapSort.setMovements(0);
                break;

            case 6:
                int max = array[0];
                for (int i = 0; i < array.length; i++) {
                    if (array[i] > max) {
                        max = array[i];
                    }
                }
                RadixSort.radixsort(array, max);
                comparisons = RadixSort.getComparisons();
                movements = RadixSort.getMovements();
                runningTime = RadixSort.getRunningTime();
                RadixSort.setComparisons(0);
                RadixSort.setMovements(0);
                break;
        }
        System.out.println("Experimental Results:");
        System.out.println("Input Size: " + array.length);
        System.out.println("Data Type: " + dataType);
        System.out.println("Sort: " + sortAlgos[sortAlgo - 1]);
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Movements: " + movements);
        System.out.println("Running Time: " + runningTime);
    }
}
