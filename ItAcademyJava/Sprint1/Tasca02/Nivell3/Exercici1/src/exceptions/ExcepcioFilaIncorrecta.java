package exceptions;

public class ExcepcioFilaIncorrecta extends Exception{
	
	private static String missatgeEFI;

	public ExcepcioFilaIncorrecta(String missatge) {
		missatgeEFI = missatge;
	}


}
