package experiment;

import java.io.*;
import java.util.Random;

public class RandomGen {
	public void genFiles(int N) throws IOException {
		// Create a directory data at the current level (if one does not exist)
		new File("./data/").mkdirs();
		System.out.printf("[Generating input for N = %d]\n", N);
		for (int i=1; i<=10; i++) {
			// Create 10 randomly generated input files
			String filename = String.format("data/input_%d_%d.txt", N, i);
			createFile(filename, N);
		}
	}

	public void createFile(String filename, int N) throws IOException{
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(new File(filename)));
			Random rand = new Random();
			for (int i=0; i<N; i++) {
				writer.write(rand.nextInt(1000001) + "\n");
			}
			writer.close();
		} catch (IOException e){
			throw new IOException(String.format("Error writing file '%s'\n[%s]", filename, e));
		}
	}
}
