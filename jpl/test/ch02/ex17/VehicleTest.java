package ch02.ex17;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void startTest() {
		Vehicle v = new Vehicle();
		v.setSpeed(60);
		v.setDirection("North");
		v.setOwnerName("atsuhiro");

		String expectInfo = "carID: 1 speed: 60 direction: North ownerName: atsuhiro";
		assertThat(v.getSpeed(), is(60));
		assertThat(v.getDirection(), is("North"));
		assertThat(v.getOwnerName(), is("atsuhiro"));
		assertThat(v.getCarID(), is(1));

		v.turn(Vehicle.TURN_RIGHT);

		v.turn(Vehicle.TURN_LEFT);

		double degree = 30.0;
		v.turn(degree);
	}
}
