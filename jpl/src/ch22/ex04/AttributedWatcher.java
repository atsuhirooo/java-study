package ch22.ex04;

import java.util.Observable;
import java.util.Observer;

public final class AttributedWatcher<E> implements Observer {

	public static void main(String... args) {

	}

	private final AttributedImpl<E> attribeted;

	public AttributedWatcher(AttributedImpl<E> attributed) {

		this.attribeted = attributed;
	}

	@Override
	public void update(Observable o, Object arg) {

		System.out.println("update called");
	}
}
