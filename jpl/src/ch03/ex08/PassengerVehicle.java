package ch03.ex08;

public class PassengerVehicle extends Vehicle {
	private int seatNum;
	private int passengerNum;

	public PassengerVehicle(int seatNum, int passengerNum, int speed, String direction, String ownerName) {
		super(speed, direction, ownerName);
		this.seatNum = seatNum;
		this.passengerNum = passengerNum;
	}

	public int getPassengerNum() {
		return passengerNum;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public PassengerVehicle clone() {
		return (PassengerVehicle) super.clone();
	}

	public static void main(String[] args) {

		PassengerVehicle pv1 = new PassengerVehicle(4, 2, 60, "a", "north");

		PassengerVehicle pv2 = pv1.clone();

		System.out.println("passenger:" + pv1.getPassengerNum() + " seat:" + pv1.getSeatNum());

		System.out.println("passenger:" + pv2.getPassengerNum() + " seat:" + pv2.getSeatNum());

	}

}
