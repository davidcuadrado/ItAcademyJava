package Instruments;

public class Percussio extends Instrument{
	
	public Percussio(String nom, int preu) {
		super(nom, preu);
	}

	public void tocar() {
		System.out.println("Està sonant un instrument de percussió. ");
	}

}
