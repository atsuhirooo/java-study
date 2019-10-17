package ch03.ex06;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void startTest() {
		Vehicle v1 = new Vehicle(10, "north", "a", new GasTank());
		v1.start();
		assertThat(v1.getEnergySource().isEmpty, is(false));

		Vehicle v2 = new Vehicle(20, "north", "b", new Battery());
		v2.start();
		assertThat(v2.getEnergySource().isEmpty, is(false));
	}

}
