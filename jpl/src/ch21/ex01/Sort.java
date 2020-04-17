
package ch21.ex01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Sort {

	public static void main(String[] args) throws IOException {
		// File file = new File("name.txt");
		try (BufferedReader bufReader = new BufferedReader(new FileReader(new File(args[0])))) {
			List<String> words = new ArrayList<>();
			String word;
			while ((word = bufReader.readLine()) != null) {
				words.add(word);
			}
			Collections.sort(words);

			System.out.println(words);
		}
	}

}
