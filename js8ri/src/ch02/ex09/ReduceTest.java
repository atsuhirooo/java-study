package ch02.ex09;

import java.util.ArrayList;
import java.util.stream.Stream;

public final class ReduceTest {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);

		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(3);
		list2.add(4);

		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(5);
		list3.add(6);

		Stream<ArrayList<Integer>> stream = Stream.of(list1, list2, list3);

		ArrayList<Integer> result = stream.reduce(new ArrayList<>(), (total, list) -> {
			for (Integer i : list) {
				total.add(i);
			}
			return total;
		}, (total1, total2) -> {
			total1.addAll(total2);
			return total1;
		});
		System.out.println(result);

	}
}
