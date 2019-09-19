package ch02.ex04;

public class Vehicle {
	public int carID;
	public static int nextID = 0;
	public int speed;
	public String direction;
	public String ownerName;

	public Vehicle(int speed, String direction, String ownerName) {

		this.speed = speed;
		this.direction = direction;
		this.ownerName = ownerName;
		this.carID = nextID;
		nextID++;
	}

}
