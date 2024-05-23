package s102n3e1_gestio;

import java.util.ArrayList;
import exceptions.*;

public class GestioButaques {

	private ArrayList<Butaca> butaques;

	public GestioButaques() {
		this.butaques = new ArrayList<Butaca>();
	}

	public ArrayList<Butaca> getButaques() {
		return butaques;
	}

	public void afegirButaca(Butaca butaca) {

		int posicioButaques = cercarButaca(butaca.getNumFila(), butaca.getNumSeient());

		try {

			if (posicioButaques == -1) {
				System.out.println("S'ha afegit la reserva de butaca " + butaca.toString() + ". ");
				butaques.add(butaca);
			} else {
				throw new ExcepcioButacaOcupada("Aquesta butaca ja es troba reservada. ");
			}
		} catch (ExcepcioButacaOcupada e) {
			System.out.println("Aquesta butaca ja es troba reservada. ");
		}

	}

	public void eliminarButaca(int numFila, int numSeient) {

		int posicioButaques = cercarButaca(numFila, numSeient);

		try {

			if (posicioButaques >= 0) {
				System.out.println(
						"S'ha eliminat la reserva de la butaca " + butaques.get(posicioButaques).toString() + ". ");
				butaques.remove(posicioButaques);

			} else {
				throw new ExcepcioButacaLliure("Aquesta butaca no es troba reservada. ");
			}
		} catch (ExcepcioButacaLliure e) {
			System.out.println("Aquesta butaca no es troba reservada. ");
		}
	}

	public int cercarButaca(int numFila, int numSeient) {
		int posicioButaques = -1;
		
		for (Butaca butaca : butaques) {
			if (butaca.getNumFila() == numFila && butaca.getNumSeient() == numSeient) {
				// butacaFound = true;
				posicioButaques = butaques.indexOf(butaca);
			}

		}
		return posicioButaques;

	}

}