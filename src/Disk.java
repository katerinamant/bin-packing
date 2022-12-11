import java.lang.Comparable;

public class Disk implements Comparable<Disk> {
	private static int id = 0;
	private myLinkedList<Integer> folders;
	private final int memory;
	private int availableMemory;

	public Disk() {
		id++;
		folders = new myLinkedList<Integer>();
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

	public int getFreeSpace() {
		return availableMemory;
	}

	public int getUsedMemory() {
		return memory-availableMemory;
	}

	@Override
	public int compareTo(Disk other) {
		int A = availableMemory, B = other.getFreeSpace();
		if (A == B) {
			return 0;
		}
		return A>B ? 1 : -1;
	}
}
