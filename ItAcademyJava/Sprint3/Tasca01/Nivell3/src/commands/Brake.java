package commands;

import vehicles.Vehicle;

public class Brake implements Command {

	private Vehicle vehicle;

	public Brake(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void execute() {
		this.vehicle.brake();
	}

}