package ch02.ex06;

public class Vehicle {
	private int carID;
	private static int nextID = 0;
	private int speed;
	private String direction;
	public String ownerName;

	public Vehicle(int speed, String direction, String ownerName) {

		this.speed = speed;
		this.direction = direction;
		this.ownerName = ownerName;
		this.carID = nextID;
		nextID++;
	}

	public String vehicleInfo() {
		String info = "carID: " + this.carID + " speed: " + this.speed + " direction: " + this.direction
				+ " ownerName: " + this.ownerName;
		return info;
	}

	public static void main(String[] args) {
		Vehicle v1 = new Vehicle(10, "west", "a");
		System.out.println(v1.vehicleInfo());

		Vehicle v2 = new Vehicle(20, "west", "b");
		System.out.println(v2.vehicleInfo());
	}

}
