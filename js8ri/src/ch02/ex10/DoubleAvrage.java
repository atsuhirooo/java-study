package ch02.ex10;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public final class DoubleAvrage {

	public static double calculateAverage(Stream<Double> stream) {

		final AtomicInteger[] counter = new AtomicInteger[1];
		double sum = stream.reduce(0.0, (total, number) -> {
			total = total + number;
			counter[0].incrementAndGet();
			return total;
		}, (total1, total2) -> total1 + total2);

		return sum / counter[0].get();
	}

}
