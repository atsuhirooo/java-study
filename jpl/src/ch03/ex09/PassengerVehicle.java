package ch03.ex09;

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

	public String toString() {

		return super.toString() + " seatNum:" + String.valueOf(seatNum) + " passengerNum:"
				+ String.valueOf(passengerNum);
	}

}
