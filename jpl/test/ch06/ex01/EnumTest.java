package ch06.ex01;

import org.junit.Test;

public class EnumTest {
	// 目視確認
	@Test
	public void startTest() {

		for (DayOfWeek a : DayOfWeek.values())
			System.out.println(a);

		for (TrafficLight trafficLight : TrafficLight.values())
			System.out.println(trafficLight);
	}

}
