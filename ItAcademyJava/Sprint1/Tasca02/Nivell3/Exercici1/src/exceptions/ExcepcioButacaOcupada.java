package exceptions;

public class ExcepcioButacaOcupada extends Exception{
	
	private static String missatgeEBO;

	public ExcepcioButacaOcupada(String missatge) {
		missatgeEBO = missatge;
	}

}
