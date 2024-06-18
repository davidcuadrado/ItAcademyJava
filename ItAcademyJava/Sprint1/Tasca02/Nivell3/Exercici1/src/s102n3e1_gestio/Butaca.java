package s102n3e1_gestio;

import java.util.Objects;

public class Butaca {
	private int numFila;
	private int numSeient;
	private String nomPersona;
	
	public Butaca(int numFila, int numSeient, String nomPersona) {
		this.numFila = numFila;
		this.numSeient = numSeient;
		this.nomPersona = nomPersona;
	}

	public int getNumFila() {
		return numFila;
	}

	public int getNumSeient() {
		return numSeient;
	}

	public String getNomPersona() {
		return nomPersona;
	}

	
	@Override
	public boolean equals(Object butacaOtra) {
		Butaca butaca2 = (Butaca) butacaOtra;
		if (this.numFila == butaca2.getNumFila() && this.numSeient == butaca2.getNumSeient()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Fila: " + numFila + ", Seient: " + numSeient + ", Persona: " + nomPersona + ", ";
	}
	
	
	
	
	
	

}
