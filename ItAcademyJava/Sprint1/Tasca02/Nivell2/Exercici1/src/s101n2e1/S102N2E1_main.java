package s101n2e1;

public class S102N2E1_main {

	public static void main(String[] args) throws Exception {
		boolean correcte = false;

		while (!correcte) {
			String nom = Entrada.llegirString("Introdueixi el seu nom: ");
			byte edat = Entrada.llegirByte("Introdueixi la seva edat: ");
			int dniInt = Entrada.llegirInt("Introdueixi el seu codi numèric del DNI: ");
			char dniChar = Entrada.llegirChar("Introdueixi la lletra del seu DNI: ");
			float alçada = Entrada.llegirFloat("Introdueixi la seva alçada (en metres)");
			double pi = Entrada.llegirDouble("Introdueixi el valor de pi començant per les unitats: ");

			System.out.println("El seu nom es " + nom + ". ");
			System.out.println("La seva edat es " + edat + " anys. ");
			System.out.println("El seu DNI es " + dniInt + dniChar + ". ");
			System.out.println("Amb una alçada de " + alçada + " metres. ");
			System.out.println("I indica que el valor del número Pi és " + pi + ". ");

			correcte = Entrada
					.llegirSiNo("És això correcte? Indiqui si està d'acord amb \'s\' o en desacord amb \'n\': ");
			System.out.println("Segons el que ha indicat, això és " + correcte + ". ");

		}

		System.out.println("** Fi del programa ** ");

	}

}
