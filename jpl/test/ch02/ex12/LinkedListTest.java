package ch02.ex12;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void showTest() {

		Vehicle v1 = new Vehicle("a");
		v1.setSpeed(10);
		v1.setDirection("East");

		LinkedList ll = new LinkedList(v1);

		Vehicle[] vArray = new Vehicle[2];
		vArray[0] = new Vehicle("b");
		vArray[0].setSpeed(20);
		vArray[0].setDirection("West");

		vArray[1] = new Vehicle("c");
		vArray[1].setSpeed(40);
		vArray[1].setDirection("West");

		ll.add(vArray);

		String expectResult = "[carID: 1 speed: 10 direction: East ownerName: a]%n[carID: 2 speed: 20 direction: West ownerName: b]%n[carID: 3 speed: 40 direction: West ownerName: c]";
		System.out.printf(expectResult);
		assertThat(ll.toString(), is(expectResult));

	}
}
