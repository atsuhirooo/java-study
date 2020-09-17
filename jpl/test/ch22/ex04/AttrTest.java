package ch22.ex04;

import org.junit.Test;

public class AttrTest {

	@Test
	public void testAttr() {
		final Attr<Integer> attr = new Attr<>("int", 1);
		final AttributedImpl<Integer> observableAttributed = new AttributedImpl<>();
		final AttributedWatcher<Integer> observer = new AttributedWatcher<>(observableAttributed);
		observableAttributed.addObserver(observer);

		System.out.println("add");
		observableAttributed.add(attr);

		System.out.println("remove");
		observableAttributed.remove(attr.getName());

	}
}
