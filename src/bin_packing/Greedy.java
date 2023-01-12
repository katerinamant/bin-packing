package bin_packing;

public class Greedy {
	public static int solve(MyLinkedList<Integer> folders, int totalFolderSize, boolean sort, boolean print) {
		MaxPQ<Disk> prioq = new MaxPQ<Disk>(folders.size());

		// Sort folders before greedily assigning them to disks
		// Only sort if we are running the greedy-decreasing variation
		if(sort) folders = Sort.sort(folders);

		while (!folders.isEmpty()) {
			// Deal with each folder one by one
			// Store the folder at the disk used with the most available space
			// If that is not possible, create a new disk and store the folder there
			int f = folders.popFront();
			if (prioq.isEmpty() || f > prioq.peek().getAvailableMemory()) {
				prioq.insert(new Disk(f));
			} else if (f <= prioq.peek().getAvailableMemory()) {
				prioq.peek().insertFolder(f);
				prioq.update();
			}
		}

		if (print) {
			// Print results of algorithm run
			// Happens only when calling this function from src.bin_packing.Greedy.main()
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

		return prioq.size();
	}

	public static void main(String[] args) throws Exception {
		ReadFileApp reader = new ReadFileApp();
		reader.readFile(args[0], true);
		solve(reader.getFolders(), reader.getTotalFolderSize(), false, true);
	}

}
