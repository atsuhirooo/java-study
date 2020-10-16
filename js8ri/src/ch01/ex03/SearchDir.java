package ch01.ex03;

import java.io.File;
import java.io.IOException;

public final class SearchDir {

	public static String[] findDirLambda(File directory, final String ext) throws IOException {

		String[] files = directory.list((file, name) -> name.endsWith(ext));

		return files;
	}
}
