package ch06.ex02;

public class Vehicle {
	final private int carID;
	private static int ID = 0;
	private int speed;
	private String direction = "";
	private String ownerName = "";

	public enum TurnDirection {
		TURN_LEFT, TURN_RIGHT,

	}

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
		return speed;
	}

	public String getDirection() {
		return direction;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public int getCarID() {
		return carID;
	}

	public void turn(double degree) {
		System.out.println(degree);
	}

	public void turn(TurnDirection rl) {
		if (rl == TurnDirection.TURN_RIGHT) {
			System.out.println("trun right");

		} else if (rl == TurnDirection.TURN_LEFT) {
			System.out.println("turn left");
		}
	}

	public static final int TURN_RIGHT = 0;
	public static final int TURN_LEFT = 1;

}
