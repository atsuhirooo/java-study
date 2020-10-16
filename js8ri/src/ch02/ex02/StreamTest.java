package ch02.ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class StreamTest {

	private static int MAX_NUM = 5;
	private static int CRITERIA = 3;

	public static void main(String[] args) {

		List<String> words = new ArrayList<>();
		words.add("aaaa");
		words.add("bbbb");
		words.add("c");
		words.add("ddddddd");
		words.add("eeeee");
		words.add("ffff");
		words.add("ggggg");

		Stream<String> wordStream = words.stream();
		Set<String> extractedWords = wordStream.filter(w -> {
			System.out.println("call filter for " + w);
			return w.length() > CRITERIA;
		}).limit(MAX_NUM).collect(Collectors.toSet());

	}

}
