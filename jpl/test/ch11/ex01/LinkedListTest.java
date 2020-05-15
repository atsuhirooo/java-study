package ch11.ex01;

import org.junit.Test;

public class LinkedListTest {
	@Test
	public void showTest() {
		LinkedList<Object> ll = new LinkedList<Object>();
		ll.add(new Object());
		ll.add(new Object());
		ll.add(new Object());
		ll.showlist();

		LinkedList<String> ll2 = new LinkedList<String>();
		ll2.add(new String("a"));
		ll2.add(new String("b"));
		ll2.add(new String("c"));
		ll2.showlist();

	}
}
