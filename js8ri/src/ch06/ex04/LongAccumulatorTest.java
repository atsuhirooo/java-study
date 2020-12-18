package ch06.ex04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;

public final class LongAccumulatorTest {

	private static final int SIZE = 1000;

	public static void main(String[] args) {
		List<Long> values = new ArrayList<>();
		List<Long> values2 = new ArrayList<>();

		for (long i = 0; i < SIZE; i++) {
			values.add(i);
			values2.add(i);
		}

		Collections.shuffle(values);
		Collections.shuffle(values2);

		LongAccumulator max = new LongAccumulator(Long::max, values.get(0));
		Thread t1 = new Thread(() -> {
			for (Long l : values) {
				max.accumulate(l);
			}
		});

		Thread t2 = new Thread(() -> {
			for (Long l : values2) {
				max.accumulate(l);
			}
		});

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		System.out.println("max " + max.get());

		LongAccumulator min = new LongAccumulator(Long::min, values.get(0));
		t1 = new Thread(() -> {
			for (Long l : values) {
				min.accumulate(l);
			}
		});

		t2 = new Thread(() -> {
			for (Long l : values2) {
				min.accumulate(l);
			}
		});

		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		System.out.println("min " + min.get());
	}

}
