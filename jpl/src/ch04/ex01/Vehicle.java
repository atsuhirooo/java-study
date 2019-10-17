package ch04.ex01;

public class Vehicle {
	private int speed;
	private String direction;
	private String ownerName;
	private EnergySource es;

	public Vehicle(int speed, String direction, String ownerName, EnergySource es) {
		this.es = es;
		this.speed = speed;
		this.direction = direction;
		this.ownerName = ownerName;
	}

	public EnergySource getEnergySource() {
		return es;
	}

	public void start() {
		if (es.empty()) {
			System.out.println("set Energy");
			es.setEnergy();
		}

	}

	public static void main(String[] args) {
		Vehicle v1 = new Vehicle(10, "north", "a", new GasTank());
		v1.start();

		Vehicle v2 = new Vehicle(20, "north", "b", new Battery());
		v2.start();
	}
}
