package ch02.ex01;

import java.util.List;
import java.util.function.Predicate;

final class CountThread<T> extends Thread {

	private final Counter counter;
	private final List<T> words;
	private final Predicate<T> predicate;

	CountThread(Counter counter, List<T> words, Predicate<T> predicate) {

		this.counter = counter;
		this.words = words;
		this.predicate = predicate;
	}

	@Override
	public void run() {
		for (T word : words)
			if (predicate.test(word)) {
				counter.countUp();
			}
	}
}
