package ch06.ex01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicReference;

public final class LongestString {

	private static final int numOfThread = 4;

	public static void main(String[] args) throws IOException, InterruptedException {

		String contents = new String(Files.readAllBytes(Paths.get(args[0])), StandardCharsets.UTF_8);
		String[] words = contents.split("[\\P{L}]+");

		int length = words.length;

		Runnable[] runableList = new Runnable[numOfThread];

		final AtomicReference<String> longesString = new AtomicReference<>();
		for (int i = 0; i < numOfThread; i++) {
			int from = i * length / numOfThread;
			int to = (i + 1) * length / numOfThread;
			runableList[i] = () -> {
				for (int j = from; j < to; j++) {
					longesString.accumulateAndGet(words[j], (s1, s2) -> {
						return s1.length() > s2.length() ? s1 : s2;
					});
				}
			};
		}

		for (Runnable r : runableList) {
			new Thread(r).start();

		}

		System.out.println(longesString);
	}
}
