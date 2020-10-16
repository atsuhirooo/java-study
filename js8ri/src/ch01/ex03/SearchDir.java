package ch01.ex03;

import java.io.File;
import java.io.IOException;

public final class SearchDir {

	public static String[] findDirLambda(File directory, final String ext) throws IOException {

		String[] files = directory.list((file, name) -> name.endsWith(ext));

		return files;
	}

	public static void main(String[] args) {

		try {

			for (String f : findDirLambda(new File(args[0]), ".txt")) {
				System.out.println(f);

			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
