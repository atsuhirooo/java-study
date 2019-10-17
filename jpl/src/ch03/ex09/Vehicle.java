package ch03.ex09;

public class Vehicle implements Cloneable {
	private int speed;
	private String direction;
	private String ownerName;

	public Vehicle(int speed, String direction, String ownerName) {

		this.speed = speed;
		this.direction = direction;
		this.ownerName = ownerName;
	}

	public String toString() {

		return "speed:" + String.valueOf(speed) + " direction:" + direction + " ownerName:" + ownerName;
	}

	public Vehicle clone() {
		try {
			return (Vehicle) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());

		}
	}
}
