package experiment;

import java.util.Arrays;
import bin_packing.*;

public class Experiment {
	public static void compareAlgorithms(int N) throws Exception {
		System.out.println("Testing for N = " + N + "\n");
		int sortedSum = 0, unsortedSum = 0;
		ReadFileApp reader = new ReadFileApp();

		StringBuilder res = new StringBuilder();
		res.append(" [input#] |     [SORTED]    |  [UNSORTED]\n");
		res.append("----------|-----------------|--------------\n");

		for (int i=1; i<=10; i++) {
			reader.readFile("data/input_"+N+"_"+i+".txt", false);

			// Sort folders first
			int sorted = Greedy.solve(reader.getFolders(), reader.getTotalFolderSize(), true, false);
			sortedSum += sorted;

			// Unsorted folders list
			int unsorted = Greedy.solve(reader.getFolders(), reader.getTotalFolderSize(), false, false);
			unsortedSum += unsorted;

			res.append(String.format("    %2d    |       %7d   |      %7d\n", i, sorted, unsorted));
		}
		res.append("\nAvg. disks used for greedy-decreasing: " + sortedSum/10 + "\n");
		res.append("Avg. disks used for greedy-unsorted: " + unsortedSum/10);
		System.out.println(res);
		System.out.println("\n");
	}

	public static void main(String args[]) throws Exception{
		// Example of program execution "java Experiment 3 100 500 1000"

		// Set up experiment by creating input files
		int tests = Integer.parseInt(args[0]);
		int[] N = new int[tests];
		for (int i=0; i<tests; i++) {
			N[i] = Integer.parseInt(args[i+1]);
		}

		System.out.println("Running tests for N: " + Arrays.toString(N) + "\n");
		RandomGen inputGen = new RandomGen();
		for (int i=0; i<tests; i++) {
			inputGen.genFiles(N[i]);
			compareAlgorithms(N[i]);
		}
	}

}
