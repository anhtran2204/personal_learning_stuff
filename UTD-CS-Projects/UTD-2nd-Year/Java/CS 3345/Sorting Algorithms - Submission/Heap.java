
public class Heap<E extends Comparable<E>> {
	private java.util.ArrayList<E> list = new java.util.ArrayList<>();

	private int comparisons = 0;
	private int movements = 0;
	
	/** Create a default heap */
	public Heap() {
	}
	
	/** Create a heap from an array of objects */
	public Heap(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	public int getComparisons() {
		return this.comparisons;
	}

	public int getMovements() {
		return this.movements;
	}

	/**	Add a new object into the heap */
	public void add(E newObject) {
		list.add(newObject); //	Append to the heap
		int currentIndex = list.size()-1; // The index of the last node
		
		while (currentIndex > 0) {
			comparisons++;
			int parentIndex = (currentIndex -1)/2;
			//	Swap if the current object is greater than its parent
			if (list.get(currentIndex).compareTo(
					list.get(parentIndex)) > 0) {
				comparisons++;
				E temp = list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, temp);
				movements++;
			}
			else {
				comparisons++;
				break; // The tree is a heap now
			}
			
			currentIndex = parentIndex;
			movements++;
		}
	}
	
	/** Remove the root from the heap */
	public E remove() {
		if (list.size() == 0) {
			comparisons++;
			return null;
		}
		
		E removedObject = list.get(0);
		list.set(0, list.get(list.size()-1));
		list.remove(list.size()-1);
		movements++;
		
		int currentIndex = 0;
		while (currentIndex < list.size()) {
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;
			
			//	Find the maximum between two children
			if (leftChildIndex >= list.size()) {
				break; // The tree is a heap
			}
			int maxIndex = leftChildIndex;
			if (rightChildIndex < list.size()) {
				comparisons++;
				if (list.get(maxIndex).compareTo(
						list.get(rightChildIndex)) < 0) {
					maxIndex = rightChildIndex;
					movements++;
				}		
			}
			
			//	Swap if the current node is less than the maximum
			comparisons++;
			if (list.get(currentIndex).compareTo(
					list.get(maxIndex)) < 0) {
				E temp = list.get(maxIndex);
				list.set(maxIndex, list.get(currentIndex));
				list.set(currentIndex, temp);
				currentIndex = maxIndex;
				movements++;
			}
			else {
				break; // The tree is a heap
			}
		}
		
		return removedObject;
	}
	
	/** Get the number of nodes in the tree */
	public int getSize() {
		return list.size();
	}
}
