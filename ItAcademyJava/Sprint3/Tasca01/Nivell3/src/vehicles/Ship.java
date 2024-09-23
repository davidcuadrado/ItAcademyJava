package vehicles;

public class Ship extends Vehicle {

	public Ship(String brand, String model) {
		super(brand, model);
	}

	@Override
	public void start() {
		System.out.println("Ship " + brand + " " + model + " ready to go. ");

	}

	@Override
	public void accelerate() {
		System.out.println("Ship " + brand + " " + model + " accelerating. ");

	}

	@Override
	public void brake() {
		System.out.println("Ship " + brand + " " + model + " braking. ");

	}

}