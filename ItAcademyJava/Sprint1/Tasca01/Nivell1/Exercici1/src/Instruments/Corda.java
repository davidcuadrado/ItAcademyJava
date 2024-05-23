package Instruments;

public class Corda extends Instrument{
	
	public Corda(String nom, int preu) {
		super(nom, preu);
	}
	
	static {
		System.out.println("La clase Corda se ha cargado correctamente. ");
	}

	public void tocar() {
		System.out.println("Està sonant un instrument de corda. ");
	}

}
