package ch01.ex04;

import java.io.File;
import java.util.Arrays;

public final class SortFiles {

	public static void sortFile(File[] files) {

		Arrays.sort(files, (file1, file2) -> {

			if (file1.isDirectory() == file2.isDirectory()) {
				return file1.compareTo(file2);
			}
			return file1.isDirectory() ? -1 : 1;
		});
	}

	public static void main(String[] args) {

		File[] files = new File(args[0]).listFiles();

		sortFile(files);

		for (File f : files) {
			System.out.println(f.getName());

		}

	}
}
