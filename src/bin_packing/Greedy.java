package bin_packing;

public class Greedy {
	public static void solve(MyLinkedList<Integer> folders, int totalFolderSize, boolean sort) {
		MaxPQ prioq = new MaxPQ(folders.size());

		while (!folders.isEmpty()) {
			int f = folders.popFront();
			if (prioq.isEmpty() || f > prioq.peek().getAvailableMemory()) {
				prioq.insert(new Disk(f));
			} else if (f <= prioq.peek().getAvailableMemory()) {
				prioq.peek().insertFolder(f);
			}
		}

		StringBuilder res = new StringBuilder();
		res.append(String.format("Sum of all folders = %.6f TB\n", totalFolderSize/1000000f));
		res.append("Total number of disks used = " + prioq.size() + "\n\n");

		if (folders.size() <= 100) {
			res.append(" [#] | [AVAILABLE MEMORY] | [FOLDERS]\n");
			res.append("-----|--------------------|----------\n");
			while (!prioq.isEmpty()) {
				res.append(prioq.getMax() + "\n");
			}
		}

		System.out.println(res);
	}
	public static void main(String[] args) throws Exception {
		ReadFileApp reader = new ReadFileApp();
		reader.readFile(args[0]);
		System.out.println("Calling with: " + reader.getFolders());
		//solve(reader.getFolders(), reader.getTotalFolderSize(), true);
		MyLinkedList<Integer> sortedFolders = Sort.sort(reader.getFolders());
		System.out.println(sortedFolders);

	}

}
