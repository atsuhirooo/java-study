package ch22.ex04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

public final class AttributedImpl<E> extends Observable implements Attributed<E> {

	private final List<Attr<E>> attrs = new ArrayList<>();

	@Override
	public void add(Attr<E> newAttr) {
		attrs.add(newAttr);
		setChanged();
		notifyObservers(newAttr);
	}

	@Override
	public Attr<E> find(String attrName) {

		for (final Attr<E> attr : attrs) {
			if (attrName.equals(attr.getName())) {
				return attr;
			}
		}
		return null;
	}

	@Override
	public Attr<E> remove(String attrName) {
		final Attr<E> attr = find(attrName);
		if (attr == null) {
			return null;
		}
		attrs.remove(attr);
		setChanged();
		notifyObservers(attr);
		return attr;
	}

	@Override
	public Iterator<Attr<E>> attrs() {
		return attrs.iterator();
	}

}
