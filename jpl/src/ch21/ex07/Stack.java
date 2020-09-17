package ch21.ex07;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack<E> {

	List<E> list = new ArrayList<>();
	// int stack_length;

	public void pop() {
		if (list.size() < 0)
			throw new EmptyStackException();

		list.remove(list.size() - 1);

	}

	public void push(E e) {

		list.add(e);
	}

	public E peek() {

		if (list.size() < 0)
			throw new EmptyStackException();
		return list.get(list.size() - 1);

	}

	public int Search(E e) {

		int index = list.indexOf(e);
		return index == -1 ? -1 : list.size() - index;

	}

}
