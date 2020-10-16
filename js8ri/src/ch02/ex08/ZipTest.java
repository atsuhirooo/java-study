package ch02.ex08;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ZipTest {

	public static void main(String[] args) {
		Stream<Integer> test = zip(Stream.of(1, 2, 3), Stream.of(-1, -2, -3));
		test.forEach(System.out::println);
	}

	public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {

		final List<T> list1 = first.collect(Collectors.toList());
		final List<T> list2 = second.collect(Collectors.toList());
		final int minSizeOfLists = Math.min(list1.size(), list2.size());

		List<T> resultList = new ArrayList<>();

		for (int i = 0; i < minSizeOfLists; i++) {
			resultList.add(list1.get(i));
			resultList.add(list2.get(i));
		}
		return resultList.stream();
	}
}
