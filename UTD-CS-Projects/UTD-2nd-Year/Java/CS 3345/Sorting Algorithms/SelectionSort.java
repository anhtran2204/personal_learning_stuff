
public class SelectionSort {
	private static int comparisons = 0;
	private static int movements = 0;
	private static int runningTime = 0;

	public static void setComparisons(int comparisons) {
		SelectionSort.comparisons = comparisons;
	}

	public static void setMovements(int movements) {
		SelectionSort.movements = movements;
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

	/** The method for sorting the numbers */
	public static void selectionSort(int[] list) { //int[] list?
		long startTime = System.nanoTime();
		for (int i = 0; i < list.length -1; i++) {
			// Find the minimum in the list[i..list.length-1]
			int currentMin = list[i];
			int currentMinIndex = i;

			for (int j = i+1; j < list.length; j++) {
				comparisons++;
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
					movements++;
				}
			}
			
			//	Swap list[i] wiht list[currentMinIndex[ if necessary
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
		long stopTime = System.nanoTime();
		long totalTime = stopTime - startTime;

		runningTime = (int) totalTime/1000000;
	}
}
