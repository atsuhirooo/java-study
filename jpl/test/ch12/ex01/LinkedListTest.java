package ch12.ex01;

import org.junit.Test;

public class LinkedListTest {
	@Test(expected = ObjectNotFoundException.class)
	public void showTest() throws Throwable {

		LinkedList<String> ll2 = new LinkedList<String>();
		ll2.add(new String("a"));
		ll2.add(new String("b"));
		ll2.add(new String("c"));
		ll2.showlist();

		try {
			ll2.find("d");
		} catch (Exception e) {
			throw e.getCause();
		}
	}
}
