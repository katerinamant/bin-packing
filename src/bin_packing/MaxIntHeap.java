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

	public void insert(Disk key) {
		/*
		 * Inserts Disk while maintaining decreasing order
		 */
		ensureCapacity();
		heap[++size] = key;
		heapifyUp();
	}

	public Disk getMax() throws NoSuchElementException {
		/*
		 * Returns Disk with maximum available space
		 */
		if (isEmpty()) throw new NoSuchElementException("ERROR: Invoking getMax() on an empty heap.");
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
		int i = size, p = i/2;
		while (i/2 > 0 && heap[i].compareTo(heap[p]) > 0) {
			//while (parent exists) && (availableMemory of Disk[i] > availableMemory of Disk[p])
			swap(i, p);
			i = p;
			p = i/2;
		}
	}

	public void heapifyDown() {
		/*
		 *Restores order when the maximum element is removed
		 */
		int i = 1, l = 2*i, r = 2*i + 1;
		while(l <= size) {	//while left child exists
			int m = l;
			if (r <= size && heap[r].compareTo(heap[l]) > 0) {
				//while (right child exists) && (availableMemory of Disk[r] > availableMemory of Disk[l])
				m = r;
			}
			if (heap[i].compareTo(heap[m]) > 0) {
				//if availableMemory of Disk[i] > maximum(availableMemory of left child, availableMemory of right child)
				break;
			}
			swap(i, m);
			i = m;
			l = 2*i;
			r = l+1;
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
}
