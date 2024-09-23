package s301n3;

import commands.*;
import vehicles.*;

public class Initializer {
	
		private Vehicle vehicle;
	
	public Vehicle initVehicle() {
		Car car = new Car("Hyundai", "Getz");
		Bike bike = new Bike("Peugeot", "Velo");
		Ship ship = new Ship("Harland & Wolff", "Titanic");
		Plane plane = new Plane("Boeing", "747");
		
		int random = (int) (Math.random()*4+1);
		switch(random) {
		case 1 -> this.vehicle = car;
		case 2 -> this.vehicle = bike;
		case 3 -> this.vehicle = ship;
		case 4 -> this.vehicle = plane;
		}
		System.out.println("You are using the " + vehicle.getClass() + " " + vehicle.getBrand() + " " + vehicle.getModel() + " today ");
		return vehicle;
	}
	
	public static void initRun(Vehicle vehicle) {
		Accelerate accelerator = new Accelerate(vehicle);
		accelerator.execute();
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
	
	

}
