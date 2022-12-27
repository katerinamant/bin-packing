package bin_packing;

public class Greedy {
	public static int solve(MyLinkedList<Integer> folders, int totalFolderSize, boolean sort, boolean print) {
		MaxPQ prioq = new MaxPQ(folders.size());

		if(sort) folders = Sort.sort(folders);

		while (!folders.isEmpty()) {
			int f = folders.popFront();
			if (prioq.isEmpty() || f > prioq.peek().getAvailableMemory()) {
				prioq.insert(new Disk(f));
			} else if (f <= prioq.peek().getAvailableMemory()) {
				prioq.peek().insertFolder(f);
				prioq.update();
			}
		}

		if (print) {
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
