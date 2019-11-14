package ch02.ex16;

public class LinkedList {
	ListElement head;

	public LinkedList(Vehicle value) {

		head = new ListElement(value);

	}

	public void add(Vehicle value) {
		if (head == null)
			head = new ListElement(value);
		else {
			ListElement tmp = head;
			while (tmp.getNext() != null) {
				tmp = tmp.getNext();
			}
			tmp.setNext(new ListElement(value));
		}
	}

	public void add(Vehicle... values) {

		for (int i = 0; i < values.length; i++) {
			if (head == null)
				head = new ListElement(values[i]);
			else {
				ListElement tmp = head;
				while (tmp.getNext() != null) {
					tmp = tmp.getNext();
				}
				tmp.setNext(new ListElement(values[i]));
			}
		}
	}

	public String toString() {
		ListElement tmp = this.head;
		String info = "[";
		while (tmp != null && tmp.getValue() != null) {
			info += tmp.getValue().toString();
			tmp = tmp.getNext();
			if (tmp != null)
				info += "]%n[";
		}
		info += "]";
		return info;
	}

	public int getLength() {
		ListElement tmp = this.head;
		int count = 0;
		while (tmp != null) {
			count++;
			tmp = tmp.getNext();
		}
		return count;
	}
}
