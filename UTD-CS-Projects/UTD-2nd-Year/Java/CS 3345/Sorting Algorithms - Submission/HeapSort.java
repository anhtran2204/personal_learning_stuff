
public class HeapSort {
	private static int comparisons = 0;
	private static int movements = 0;
	private static int runningTime = 0;

	public static void setComparisons(int comparisons) {
		HeapSort.comparisons = comparisons;
	}

	public static void setMovements(int movements) {
		HeapSort.movements = movements;
	}

	public static int getComparisons() {
		return comparisons;
	}

	public static int getMovements() {
		return movements;
	}

	public static int getRunningTime() {
		return runningTime;
	}
	/** Heap sort method */
	public static <E extends Comparable<E>> void heapSort(E[] list) {
		long startTime = System.nanoTime();
		//	Create a Heap of integers
		Heap<E> heap = new Heap<>();

		//	Add elements to the heap
		for (int i = 0; i < list.length; i++)
			heap.add(list[i]);

		//	Remove elements from the heap
		for (int i = list.length - 1; i >= 0; i--)
			list[i] = heap.remove();

		long stopTime = System.nanoTime();
		long totalTime = stopTime - startTime;

		runningTime = (int) totalTime/1000000;
		comparisons = heap.getComparisons();
		movements = heap.getMovements();
	}
	
	
 	/**	A test method */
//	public static void main(String[] args) {
//		Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
//		heapSort(list);
//		for(int i = 0; i < list.length; i++)
//			System.out.println(list[i] + " ");
//	}
	
}
