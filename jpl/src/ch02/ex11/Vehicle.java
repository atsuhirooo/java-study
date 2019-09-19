package ch02.ex11;

public class Vehicle {
	private int carID;
	private static int ID = 0;
	private int speed;
	private String direction = "";
	private String ownerName = "";

	public static int getHighestID() {
		return ID;
	}

	public Vehicle(String ownerName) {
		this.ownerName = ownerName;
		this.carID = ID;
	}

	{
		ID++;
	}

	public Vehicle() {
		this.carID = ID;
	}

	public String toString() {
		String info = "carID: " + this.carID + " speed: " + this.speed + " direction: " + this.direction
				+ " ownerName: " + this.ownerName;
		return info;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getSpeed() {
		return this.speed;
	}

	public String setDirection() {
		return this.direction;
	}

	public String setOwnerName() {
		return this.ownerName;
	}

}
