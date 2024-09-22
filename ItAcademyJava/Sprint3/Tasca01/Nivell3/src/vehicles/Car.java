package vehicles;

public class Car extends Vehicle {

	public Car(String brand, String model) {
		super(brand, model);
	}

	@Override
	public void start() {
		System.out.println("Car " + brand + model + " ready to go. ");

	}

	@Override
	public void accelerate() {
		System.out.println("Car " + brand + model + " accelerating. ");

	}

	@Override
	public void brake() {
		System.out.println("Car " + brand + model + " braking. ");

	}

}