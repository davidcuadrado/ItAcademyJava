package s104n1e2;


public class CalculoDni {

	public CalculoDni() {

	}
	

	public char calcularLletra(int dniNum) {
		char lletraDni = '-';
		int moduloDni = dniNum % 23;

		if ((dniNum / 10000000 >= 1) && (dniNum / 100000000 < 1) && dniNum != 0) {
			String charList = "TRWAGMYFPDXBNJZSQVHLCKE";
			lletraDni = charList.charAt(moduloDni);
		} else {
			System.out.println("El número de DNI "+ dniNum+ " no és un valor correcte. ");
		}

		return lletraDni;
	}

}
