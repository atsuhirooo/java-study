package ch02.ex10;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void startTest() {
		Vehicle v = new Vehicle("atsuhiro");
		v.setSpeed(60);
		v.setDirection("North");
		String expectInfo = "carID: 1 speed: 60 direction: North ownerName: atsuhiro";
		assertThat(v.toString(), is(expectInfo));

	}
}
