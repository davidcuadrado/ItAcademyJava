package exceptions;

public class ExcepcioNomPersonaIncorrecte extends Exception {
	
	private static String missatgeENPI;

	public ExcepcioNomPersonaIncorrecte(String missatge) {
		missatgeENPI = missatge;

	}
}
