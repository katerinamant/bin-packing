package bin_packing;

import java.io.*;

public class ReadFileApp {
	private MyLinkedList<Integer> folders;
	private int totalSize = 0;

	public void readFile(String file) throws Exception {
		BufferedReader reader = null;
		System.out.printf("[Reading from file: %s]\n", file);
		reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		int linenum = 1;

		folders = new MyLinkedList<Integer>();
		while (line != null) {
			while (line.length() == 0) {
				// Skip empty lines
				System.out.printf("Empty line found. Ignoring line %d...\n", linenum);
				line = reader.readLine();
				linenum++;
			}
			line.trim();

			// Get Folder Size
			int folderSize;
			try {
				folderSize = Integer.parseInt(line);
			} catch (NumberFormatException e) {
				reader.close();
				throw new NumberFormatException(String.format("[Error when reading from file: %s]\n"
						+ "Line %d - Folder size must be a number in [0, 1000000]", file, linenum));
			}

			if (folderSize < 0 || folderSize > 1000000) {
				// Check if folder size is in [0,1000000]
				reader.close();
				throw new IOException(String.format("[Error when reading from file: %s]\n"
						+ "Line %d - Folder size out of bounds", file, linenum));
			}

			// Add folder size to linked list and increment total size
			folders.pushBack(folderSize);
			totalSize += folderSize;

			// Get next line
			line = reader.readLine();
			linenum++;
		}
		reader.close();
		System.out.printf("[Succesfully read from file: %s]\n\n", file);
	}

	public MyLinkedList<Integer> getFolders() {
		return folders;
	}

	public int getTotalFolderSize() {
		return totalSize;
	}
}
