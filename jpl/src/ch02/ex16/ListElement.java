package ch02.ex16;

public class ListElement {

	ListElement(Vehicle value) {
		this.value = value;
	}

	private Vehicle value;

	private ListElement next;

	public void setNext(ListElement next) {
		this.next = next;
	}

	public ListElement getNext() {
		return this.next;
	}

	public Vehicle getValue() {
		return this.value;
	}

}
