package ch02.ex05;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void startTest() {
		Vehicle v = new Vehicle(60, "north", "atsuhiro");
		String expectInfo = "carID: 0 speed: 60 direction: north ownerName: atsuhiro";
		assertThat(v.vehicleInfo(), is(expectInfo));

	}
}
