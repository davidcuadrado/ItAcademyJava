package exceptions;

public class ExcepcioSeientIncorrecte extends Exception {
	
	private static String missatgeESI;

	public ExcepcioSeientIncorrecte(String missatge) {
		missatgeESI = missatge;
	}

}
