package ch01.ex02;

import java.io.File;
import java.io.IOException;

public final class SearchDir {

	public static File[] findDir(File directory) throws IOException {

		File[] subDirectories = directory.listFiles(File::isDirectory);

		return subDirectories;
	}

	public static File[] findDirLambda(File directory) throws IOException {

		File[] subDirectories = directory.listFiles((f) -> f.isDirectory());

		return subDirectories;
	}

	public static void main(String[] args) {

		try {

			for (File f : findDir(new File(args[0]))) {
				System.out.println(f.getName());

			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
