package bin_packing;

import java.util.*;

public class MaxIntHeap {
	private int capacity;
	private Disk[] heap;
	private int size;

	public MaxIntHeap(int capacity) {
		this.capacity = capacity;
		heap = new Disk[capacity+1];
		size = 0;
	}

	private boolean hasParent(int i) { return i/2>0; }
	private boolean hasLeftChild(int i) { return 2*i<=size; }
	private boolean hasRightChild(int i) { return 2*i+1<=size; }

	private int getParentIndex(int i) { return i/2; }
	private int getLeftChildIndex(int i) { return 2*i; }
	private int getRightChildIndex(int i) { return 2*i+1; }

	public void insert(Disk key) {
		/*
		 * Inserts Disk while maintaining decreasing order
		 */
		ensureCapacity();
		heap[++size] = key;
		heapifyUp();
	}

	public Disk peek() throws NoSuchElementException {
		/*
		 * Returns Disk with maximum available space
		 */
		if (isEmpty()) throw new NoSuchElementException("ERROR: Invoking peek() on an empty heap.");
		return heap[1];
	}

	public Disk deleteMax() throws NoSuchElementException {
		/*
		 * Returns and removes Disk with maximum available space from heap
		 */
		if (isEmpty()) throw new NoSuchElementException("ERROR: Invoking deleteMax() on an empty heap.");
		Disk item = heap[1];
		heap[1] = heap[size];
		size--;
		heapifyDown();
		return item;
	}

	public void swap(int i, int j) {
		Disk temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	public void heapifyUp() {
		/*
		 * Bubbles up the new Disk to its correct position
		 */
		int i = size, p = getParentIndex(i);
		while (hasParent(i) && heap[i].compareTo(heap[p]) > 0) {
			swap(i, p);
			i = p;
			p = getParentIndex(i);
		}
	}

	public void heapifyDown() {
		/*
		 *Restores order when the maximum element is removed
		 */
		int i = 1, l = getLeftChildIndex(i), r = getLeftChildIndex(i);
		while(hasLeftChild(i)) {
			int m = l;
			if (hasRightChild(i) && heap[r].compareTo(heap[l]) > 0) {
				m = r;
			}
			if (heap[i].compareTo(heap[m]) > 0) {
				break;
			}
			swap(i, m);
			i = m;
			l = getLeftChildIndex(i);
			r = getRightChildIndex(i);
		}
	}

	public void ensureCapacity() {
		/*
		 * Doubles the array size when it has reached maximum capacity
		 */
		if (size == capacity) {
			heap = Arrays.copyOf(heap, capacity*2 + 1);
			capacity *= 2;
		}
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getCapacity() {
		return capacity;
	}
}
