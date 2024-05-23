package Instruments;

public class Vent extends Instrument{
	
	static {
		aire();
	}
	
	public Vent(String nom, int preu) {
		super(nom, preu);
	}

	public void tocar() {
		System.out.println("Està sonant un instrument de vent. ");
	}
	
	public static void aire() {
		byte random = (byte) ((Math.random()*3)+1);
		switch (random) {
		case 1:
			System.out.println("El aire pasa por la caña. ");
			break;
		case 2:
			System.out.println("Si se tapan los agujeros correctos dará la nota oportuna. ");
			break;
		case 3:
			System.out.println("Requiere soplar en la justa medida. ");
			break;
		}
	}

}
