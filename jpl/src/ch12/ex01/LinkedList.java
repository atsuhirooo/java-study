package ch12.ex01;

public class LinkedList<T> {
	ListElement<T> head;

	public void add(T value) {
		if (head == null)
			head = new ListElement<T>(value);
		else {
			ListElement<T> tmp = head;
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = new ListElement<T>(value);
		}
	}

	public void showlist() {
		ListElement<T> tmp = this.head;
		while (tmp != null && tmp.value != null) {
			System.out.println(tmp.value);
			tmp = tmp.next;
		}
	}

	public T find(T value) throws ObjectNotFoundException {
		ListElement<T> tmp = this.head;
		while (tmp != null && tmp.value != null) {
			if (value.equals(tmp.value))
				return tmp.value;

		}
		throw new ObjectNotFoundException();

	}
}
