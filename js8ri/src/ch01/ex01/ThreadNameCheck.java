package ch01.ex01;

import java.util.Arrays;

public class ThreadNameCheck {

	public static void main(String[] args) {

		Integer[] array = { 1, 3, 2, 4 };

		System.out.println("caller id " + Thread.currentThread().getName());
		Arrays.sort(array, (first, second) -> {

			System.out.println("callee id " + Thread.currentThread().getName());

			return Integer.compare(first, second);
		});

		System.out.println(Arrays.asList(array));
	}

}
