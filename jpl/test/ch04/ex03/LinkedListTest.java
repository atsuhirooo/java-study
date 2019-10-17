package ch04.ex03;

import org.junit.Test;

import ch03.ex10.LinkedList;

public class LinkedListTest {

	// 目視確認
	@Test
	public void startTest() {

		Object o1 = new Object();
		Object o2 = new Object();

		LinkedList ll = new LinkedList();
		ll.add(o1);
		ll.add(o2);

		LinkedList ll_copy = ll.clone();

		System.out.println("ll_address " + ll);
		System.out.println("ll_elements_address");
		ll.showlist();
		System.out.println("ll_copy_address " + ll_copy);
		System.out.println("ll_copy_elements_address");
		ll_copy.showlist();
	}
}
