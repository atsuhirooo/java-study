package ch03.ex08;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class PassengerVehicleTest {

	@Test
	public void startTest() {
		PassengerVehicle pv1 = new PassengerVehicle(4, 2, 60, "a", "north");

		assertThat(pv1.getPassengerNum(), is(2));
		assertThat(pv1.getSeatNum(), is(4));

	}

}