
public class InsertionSort {
	private static int comparisons = 0;
	private static int movements = 0;
	private static int runningTime = 0;

	public static void setComparisons(int comparisons) {
		InsertionSort.comparisons = comparisons;
	}

	public static void setMovements(int movements) {
		InsertionSort.movements = movements;
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

	/**The method for sorting the numbers */
	public static void insertionSort(int[] list) {
		long startTime = System.nanoTime();
		for (int i = 1; i < list.length; i++) {
			/** Insert list[i] into a sorted sublist list[0..i-1] so that 
			 * 	list[0..i] is sorted
			 */
			int currentElement = list[i];
			int k;
			comparisons++;
			for (k = i-1; k>= 0 && list[k] > currentElement; k--) {
				comparisons++;
				list[k+1] = list[k];
				movements++;
			}
			
			//insert the current element into list[k + 1]
			list[k + 1] = currentElement;
		}
		long stopTime = System.nanoTime();
		long totalTime = stopTime - startTime;

		runningTime = (int) totalTime / 1000000;
	}
}
