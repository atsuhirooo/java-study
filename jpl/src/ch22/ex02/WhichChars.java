package ch22.ex02;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class WhichChars {

	HashSet<Character> linkedHashSet = new LinkedHashSet<>();

	public WhichChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			linkedHashSet.add(str.charAt(i));
		}
	}

	@Override
	public String toString() {
		StringBuilder desc = new StringBuilder("[");

		TreeSet<Character> treeSet = new TreeSet<>();
		treeSet.addAll(linkedHashSet);
		for (char c : treeSet) {
			desc.append(c);
		}
		return desc.append("]").toString();
	}
}
