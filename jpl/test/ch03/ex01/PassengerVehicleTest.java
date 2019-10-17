package ch03.ex01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class PassengerVehicleTest {

	@Test
	public void startTest() {
		PassengerVehicle v = new PassengerVehicle(4, 2, 60, "north", "a");

		assertThat(v.getSpeed(), is(60));
		assertThat(v.getDirection(), is("north"));
		assertThat(v.getOwnerName(), is("a"));
		assertThat(v.getPassengerNum(), is(2));
		assertThat(v.getSeatNum(), is(4));

	}
}
