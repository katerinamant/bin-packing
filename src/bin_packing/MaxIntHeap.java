package bin_packing;

import java.util.*;

public class MaxIntHeap<T extends Comparable<T>> {
	private int capacity;
	private Object[] heap;
	private int size;

	public MaxIntHeap(int capacity) {
		this.capacity = capacity;
		heap = new Object[capacity+1];
		size = 0;
	}

	private boolean hasParent(int i) { return i/2>0; }
	private boolean hasLeftChild(int i) { return 2*i<=size; }
	private boolean hasRightChild(int i) { return 2*i+1<=size; }

	private int getParentIndex(int i) { return i/2; }
	private int getLeftChildIndex(int i) { return 2*i; }
	private int getRightChildIndex(int i) { return 2*i+1; }

	public void insert(T key) {
		/*
		 * Inserts Disk while maintaining decreasing order
		 */
		ensureCapacity();
		heap[++size] = key;
		heapifyUp();
	}

	@SuppressWarnings("unchecked")
	public T peek() throws NoSuchElementException {
		/*
		 * Returns Disk with maximum available space
		 */
		if (isEmpty()) throw new NoSuchElementException("ERROR: Invoking peek() on an empty heap.");
		return (T) heap[1];
	}

	@SuppressWarnings("unchecked")
	public T deleteMax() throws NoSuchElementException {
		/*
		 * Returns and removes Disk with maximum available space from heap
		 */
		if (isEmpty()) throw new NoSuchElementException("ERROR: Invoking deleteMax() on an empty heap.");
		T item = (T) heap[1];
		heap[1] = heap[size];
		size--;
		heapifyDown();
		return item;
	}

	@SuppressWarnings("unchecked")
	public void swap(int i, int j) {
		T temp = (T) heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	@SuppressWarnings("unchecked")
	public void heapifyUp() {
		/*
		 * Bubbles up the new Disk to its correct position
		 */
		int i = size, p = getParentIndex(i);
		while (hasParent(i) && ((T) heap[i]).compareTo((T) heap[p]) > 0) {
			swap(i, p);
			i = p;
			p = getParentIndex(i);
		}
	}

	@SuppressWarnings("unchecked")
	public void heapifyDown() {
		/*
		 *Restores order when the maximum element is removed
		 */
		int i = 1, l = getLeftChildIndex(i), r = getRightChildIndex(i);
		while(hasLeftChild(i)) {
			int m = l;
			if (hasRightChild(i) && ((T) heap[r]).compareTo((T) heap[l]) > 0) {
				m = r;
			}
			if (((T) heap[i]).compareTo((T) heap[m]) > 0) {
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
