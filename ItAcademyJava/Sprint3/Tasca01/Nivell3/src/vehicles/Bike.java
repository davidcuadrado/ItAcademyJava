package vehicles;

public class Bike extends Vehicle {

	public Bike(String brand, String model) {
		super(brand, model);
	}

	@Override
	public void start() {
		System.out.println("Bike " + brand + model + " ready to go. ");

	}

	@Override
	public void accelerate() {
		System.out.println("Bike " + brand + model + " accelerating. ");

	}

	@Override
	public void brake() {
		System.out.println("Bike " + brand + model + " braking. ");

	}

}
