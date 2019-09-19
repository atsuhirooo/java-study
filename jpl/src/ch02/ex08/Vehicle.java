package ch02.ex08;

public class Vehicle {
	private int carID;
	private static int nextID = 0;
	private int speed;
	private String direction = "";
	private String ownerName = "";

	public Vehicle(String ownerName) {
		this.ownerName = ownerName;
		this.carID = nextID;
	}

	{
		nextID++;
	}

	public Vehicle() {
		this.carID = nextID;
	}

	public String vehicleInfo() {
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

	public static void main(String[] args) {
		Vehicle v1 = new Vehicle("a");
		v1.setSpeed(10);
		v1.setDirection("East");
		System.out.println(v1.vehicleInfo());

		Vehicle v2 = new Vehicle();
		v2.setSpeed(20);
		v2.setDirection("West");
		v2.setOwnerName("b");
		System.out.println(v2.vehicleInfo());
	}

}
