package ch02.ex01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void newTest() {
		Vehicle v = new Vehicle(60, "north", "atsuhiro");
		assertThat(v.speed, is(60));

	}

}
