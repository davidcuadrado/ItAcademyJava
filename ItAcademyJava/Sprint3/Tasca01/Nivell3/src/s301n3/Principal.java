package s301n3;

import commands.*;
import vehicles.*;

public class Principal {

	public static void main(String[] args) {
		
		Initializer initializer = new Initializer();
		
		Vehicle vehicle = initializer.initVehicle();
		
		initializer.initRun(vehicle);
		
		//continuar con Vehicle.toString()
		
		

	}

}
