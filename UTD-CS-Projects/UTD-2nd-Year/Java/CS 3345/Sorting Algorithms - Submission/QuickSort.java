public class QuickSort {
	private static int comparisons = 0;
	private static int movements = 0;
	private static int runningTime = 0;

	public static int getComparisons() {
		return comparisons;
	}

	public static int getMovements() {
		return movements;
	}

	public static void setComparisons(int comparisons) {
		QuickSort.comparisons = comparisons;
	}

	public static void setMovements(int movements) {
		QuickSort.movements = movements;
	}

	public static int getRunningTime() {
		return runningTime;
	}

	public static void quickSort(int[] list) {
		long startTime = System.nanoTime();

		quickSort(list, 0, list.length-1);

		long stopTime = System.nanoTime();
		long totalTime = stopTime - startTime;

		runningTime = (int) totalTime/1000000;
	}
	
	public static void quickSort(int[] list, int first, int last) {
		comparisons++;
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex -1);
			quickSort(list, pivotIndex + 1, last);
		}
	}
	
	/** Partition the array list[first..last] */
	public static int partition(int[] list, int first, int last) {
		int pivot = (first + last) / 2; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; //Index for backward search
		
		while (high > low) {
			// Search forward from left
			while (low <= high && list[low] <= pivot) {
				low++;
			}
			
			// Search backward from right
			while (low <= high && list[high] > pivot) {
				high--;
			}
			
			//	Swap two elements in the list
			comparisons++;
			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
				movements++;
			}
		}

		while (high > first && list[high] >= pivot) {
			high--;
		}
		
		//	Swap pivot with list[high]
		if (pivot > list[high]) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else {
			return first;
		}
	}
}
