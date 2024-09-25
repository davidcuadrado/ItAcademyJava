package s301n3;

import vehicles.*;

public class Principal {

	public static void main(String[] args) {

		Initializer initializer = new Initializer();

		Vehicle vehicle = initializer.initVehicle();

		initializer.initStart(vehicle);
		initializer.initAccelerate(vehicle);
		initializer.initBreak(vehicle);

	}

}
