package ch02.ex06;

public class LinkedList {
	ListElement head;

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

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.add(new Vehicle(10, "East", "a"));
		ll.add(new Vehicle(30, "South", "b"));

	}
}
