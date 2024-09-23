package vehicles;

public class Plane extends Vehicle {

	public Plane(String brand, String model) {
		super(brand, model);
	}

	@Override
	public void start() {
		System.out.println("Plane " + brand + " " + model + " ready to go. ");

	}

	@Override
	public void accelerate() {
		System.out.println("Plane " + brand + " " + model + " accelerating. ");

	}

	@Override
	public void brake() {
		System.out.println("Plane " + brand + " " + model + " braking. ");

	}

}