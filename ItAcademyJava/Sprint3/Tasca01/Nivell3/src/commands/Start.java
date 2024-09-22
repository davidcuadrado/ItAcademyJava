package commands;

import vehicles.Vehicle;

public class Start implements Command {

	private Vehicle vehicle;

	public Start(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void execute() {
		this.vehicle.start();
	}

}