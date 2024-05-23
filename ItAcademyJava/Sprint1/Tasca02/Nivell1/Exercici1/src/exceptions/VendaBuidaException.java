package exceptions;

public class VendaBuidaException extends Exception {
	
	private static String missatgeError;


	public VendaBuidaException(String missatge) {
		missatgeError = missatge;
	}

	

}
