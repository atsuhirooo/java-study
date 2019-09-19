package ch02.ex06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void showTest() {

		LinkedList ll = new LinkedList();
		Vehicle v1 = new Vehicle(10, "East", "a");
		ll.add(v1);
		String expectInfo1 = "carID: 0 speed: 10 direction: East ownerName: a";
		assertThat(v1.vehicleInfo(), is(expectInfo1));

		Vehicle v2 = new Vehicle(20, "West", "b");
		ll.add(v2);
		String expectInfo2 = "carID: 1 speed: 20 direction: West ownerName: b";
		assertThat(v2.vehicleInfo(), is(expectInfo2));

		ll.showlist();

	}
}
