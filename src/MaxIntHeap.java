import java.util.*;

public class MaxIntHeap {
	private int capacity;
	private int[] heap;
	private int size;

	public MaxIntHeap(int capacity) {
		this.capacity = capacity;
		heap = new int[capacity+1];
		size = 0;
	}

	public void insert(int key) {
		ensureCapacity();
		heap[++size] = key;
		heapifyUp();
	}

	public int getMax() throws NoSuchElementException {
		if (isEmpty()) throw new NoSuchElementException("ERROR: Invoking getMax() on an empty heap.");
		return heap[1];
	}

	public int deleteMax() throws NoSuchElementException {
		if (isEmpty()) throw new NoSuchElementException("ERROR: Invoking deleteMax() on an empty heap.");
		int item = heap[1];
		heap[1] = heap[size];
		size--;
		heapifyDown();
		return item;
	}

	public void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	public void heapifyUp() {
		int i = size, p = i/2;
		while (i/2 > 0 && heap[i] > heap[p]) {
			swap(i, p);
			i = p;
			p = i/2;
		}
	}

	public void heapifyDown() {
		int i = 1, l = 2*i, r = 2*i + 1;
		while(l <= size) {
			int m = l;
			if (r <= size && heap[r] > heap[l]) {
				m = r;
			}
			if (heap[i] > heap[m]) break;
			swap(i, m);
			i = m;
			l = 2*i;
			r = l+1;
		}
	}

	public void ensureCapacity() {
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
