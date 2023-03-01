import java.util.Random;
import java.util.Scanner;

public class SortTest {
    private static Scanner kb = new Scanner(System.in);

    private static InsertionSort insertionSort;
    private static QuickSort quickSort;
    private static MergeSort mergeSort;
    private static SelectionSort selectionSort;
    private static RadixSort radixSort;
    private static HeapSort heapSort;

    private static final String[] dataTypes = { "InOrder", "ReverseOrder", "AlmostOrder", "Random Order" };
    private static final int[] inputSizes = { 500, 15000, 50000 };
    private static final String[] sortAlgos = {
            "Insertion Sort", "Selection Sort", "Quick Sort",
            "Merge Sort", "Heap Sort", "Radix Sort"
    };

    public static void main(String[] args) {
        print(dataTypes);
        System.out.print("List Properties, select the data type of list you wish to use: ");
        int choice = kb.nextInt();
        System.out.println();

        print(inputSizes);
        System.out.print("Input Size, select the size of list: ");
        int SIZE = kb.nextInt();
        int[] array = new int[inputSizes[SIZE-1]];

        Random random = new Random();
        switch (choice) {
            case 1:
                for (int i = 0; i < array.length; i++) {
                    array[i] = i;
                }
                break;

            case 2:
                for (int i = 0; i < array.length; i++) {
                    array[i] = array.length - i - 1;
                }
                break;

            case 3:
                

            case 4:
                for (int i = 0; i < array.length; i++) {
                    array[i] = random.nextInt(array.length);
                }
                break;
        }
        System.out.println();

        print(sortAlgos);
        System.out.print("Sorting Algorithm, select the sorting algorithm: ");
        choice = kb.nextInt();
        System.out.println();
    }

    public static void print(int[] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.println(i+1 + ". " + array[i]);
        }
    }

    public static void print(String[] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.println(i+1 + ". " + array[i]);
        }
    }

    public static void result(int sortAlgo) {
        switch (sortAlgo) {
            case 1:
                insertionSort = new InsertionSort();

            case 2:
                selectionSort = new SelectionSort();

            case 3:
                quickSort = new QuickSort();

            case 4:
                mergeSort = new MergeSort();

            case 5:
                heapSort = new HeapSort();

            case 6:
                radixSort = new RadixSort();

        }
    }
}
