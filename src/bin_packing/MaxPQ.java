package bin_packing;

import java.util.NoSuchElementException;

public class MaxPQ<T extends Comparable<T>> {
	private MaxIntHeap<T> heap;

	public MaxPQ(int capacity) {
		heap = new MaxIntHeap<T>(capacity);
	}

	public void insert(T key) {
		heap.insert(key);
	}

	public T peek() throws NoSuchElementException{
		/*
		 * Returns Disk with maximum available space
		 */
		return heap.peek();
	}

	public T getMax() throws NoSuchElementException{
		/*
		 * Returns and removes Disk with maximum available space from heap
		 */
		return heap.deleteMax();
	}

	public void update() {
		heap.heapifyDown();
	}

	public int size() {
		return heap.getSize();
	}

	public boolean isEmpty() {
		return heap.isEmpty();
	}
}
