package ch02.ex11;

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
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = new ListElement(value);
		}
	}

	public String toString() {
		ListElement tmp = this.head;
		String info = "[";
		while (tmp != null && tmp.value != null) {
			info += tmp.value.toString();
			tmp = tmp.next;
			if (tmp != null)
				info += "]%n[";
		}
		info += "]";
		return info;
	}

}
