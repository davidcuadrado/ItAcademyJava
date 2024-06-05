package s104n1e2;

import java.lang.reflect.Array;

public class CalculoDni {

	public char calcularLletra(int dniNum) {
		char lletraDni = '-';
		int moduloDni = dniNum % 23;
		// final String charList = "TRWAGMYFPDXBNJZSQVHLCKE";
		final char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
	        	'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

		if ((dniNum / 10000000 >= 1) && (dniNum / 100000000 < 1) && dniNum != 0) {
			lletraDni = (char) Array.getChar(letras, moduloDni);
		} else {
			System.out.println("El número de DNI "+ dniNum+ " no és un valor correcte. ");
		}

		return lletraDni;
	}

}
