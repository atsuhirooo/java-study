package ch02.ex08;

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

	public void showlist() {
		ListElement tmp = this.head;
		while (tmp != null && tmp.value != null) {
			System.out.println(tmp.value.vehicleInfo());
			tmp = tmp.next;
		}
	}

}
