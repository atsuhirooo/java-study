package ch06.ex05;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.awt.Color;

import org.junit.Test;

public class TrafficLightTest {

	@Test
	public void startTest() {
		assertThat(TrafficLight.valueOf("RED").getColor(), is(new Color(255, 0, 0)));
		assertThat(TrafficLight.valueOf("YELLOW").getColor(), is(new Color(255, 255, 0)));
		assertThat(TrafficLight.valueOf("GREEN").getColor(), is(new Color(0, 255, 0)));

	}

}
