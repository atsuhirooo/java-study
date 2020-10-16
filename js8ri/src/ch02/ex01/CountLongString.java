package ch02.ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CountLongString {

	private static final int CRITERIA = 12;

	public static void main(String[] args) throws InterruptedException {
		final List<String> words = Arrays.asList(args);
		System.out.println(numOfLongString(words, 3));
	}

	public static int numOfLongString(List<String> words, int segmentSize) throws InterruptedException {

		final List<CountThread<String>> countThreads = new ArrayList<>(words.size());
		final Counter counter = new Counter();
		int offset;

		for (offset = 0; offset + segmentSize < words.size(); offset += segmentSize) {
			countThreads.add(new CountThread<String>(counter, words.subList(offset, offset + segmentSize),
					s -> s.length() > CRITERIA));
		}

		countThreads
				.add(new CountThread<String>(counter, words.subList(offset, words.size()), s -> s.length() > CRITERIA));

		for (final CountThread<String> countThread : countThreads) {
			countThread.start();
		}
		for (final CountThread<String> countThread : countThreads) {
			countThread.join();
		}
		return counter.get();
	}
}
