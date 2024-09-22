package vehicles;

public abstract class Vehicle {

	protected String brand;
	protected String model;

	public Vehicle(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}

	public abstract void start();

	public abstract void accelerate();

	public abstract void brake();

}