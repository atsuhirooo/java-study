package ch12.ex01;

public class ListElement<T> {

	ListElement(T value) {
		this.value = value;
	}

	public T value;

	public ListElement<T> next;

}
