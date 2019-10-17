package ch03.ex09;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class Garage implements Cloneable {
	Vehicle[] vehicles;

	public Garage(Vehicle... vehicles) {
		this.vehicles = vehicles;

	}

	public Garage clone() {

		try {
			Garage garage = (Garage) super.clone();
			garage.vehicles = vehicles.clone();
			return garage;

		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());

		}

	}

	public String toString() {

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < vehicles.length; i++) {
			sb.append(vehicles[i].toString());

		}

		return sb.toString();

	}

	public static void main(String[] args) {

		PassengerVehicle pv1 = new PassengerVehicle(4, 2, 60, "a", "north");

		PassengerVehicle pv2 = new PassengerVehicle(6, 6, 40, "b", "west");

		Garage garage = new Garage(pv1, pv2);

		Garage garage2 = garage.clone();
		assertThat(garage.toString(), is(garage2.toString()));

	}
}
