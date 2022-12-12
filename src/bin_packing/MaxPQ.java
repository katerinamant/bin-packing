package bin_packing;

import java.util.NoSuchElementException;

public class MaxPQ {
	private MaxIntHeap heap;

	public MaxPQ(int capacity) {
		heap = new MaxIntHeap(capacity);
	}

	public void insert(Disk key) {
		heap.insert(key);
	}

	public Disk max() throws NoSuchElementException{
		/*
		 * Returns Disk with maximum available space
		 */
		return heap.getMax();
	}

	public Disk getMax() throws NoSuchElementException{
		/*
		 * Returns and removes Disk with maximum available space from heap
		 */
		return heap.deleteMax();
	}

	public int size() {
		return heap.getSize();
	}

	public boolean isEmpty() {
		return heap.isEmpty();
	}
}
