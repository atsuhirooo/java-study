package ch02.ex02;

import org.junit.Test;

public class LinkedListTest {
	@Test
	public void showTest() {
		LinkedList ll = new LinkedList();
		ll.add(new Object());
		ll.add(new Object());
		ll.add(new Object());
		ll.showlist();
	}
}
