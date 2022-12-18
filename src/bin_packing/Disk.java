package bin_packing;

import java.lang.Comparable;

public class Disk implements Comparable<Disk> {
	private static int count = 0;
	private int id;
	private MyLinkedList<Integer> folders;
	private final int memory;
	private int availableMemory;

	public Disk(int folder) {
		id = count++;
		folders = new MyLinkedList<Integer>(folder);
		memory = 1000000;
		availableMemory = memory-folder;
	}

	public Disk() {
		id++;
		folders = new MyLinkedList<Integer>();
		memory = 1000000;
		availableMemory = memory;
	}

	public void insertFolder(int mb) {
		availableMemory -= mb;
		folders.pushBack(mb);
	}

	public int getID() {
		return id;
	}

	public int getAvailableMemory() {
		return availableMemory;
	}

	public int getUsedMemory() {
		return memory-availableMemory;
	}

	@Override
	public int compareTo(Disk other) {
		int A = availableMemory, B = other.getAvailableMemory();
		if (A == B) {
			return 0;
		}
		return A>B ? 1 : -1;
	}

	@Override
	public String toString() {
		return String.format(" %3d |       %-6d       | %s", id, availableMemory, folders);
	}
}
