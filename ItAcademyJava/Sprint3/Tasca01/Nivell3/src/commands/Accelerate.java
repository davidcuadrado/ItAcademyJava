package commands;

import vehicles.Vehicle;

public class Accelerate implements Command {

	private Vehicle vehicle;

	public Accelerate(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void execute() {
		this.vehicle.accelerate();
	}

}
