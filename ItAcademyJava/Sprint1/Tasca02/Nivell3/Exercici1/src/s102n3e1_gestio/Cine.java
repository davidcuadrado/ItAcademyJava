package s102n3e1_gestio;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;

import exceptions.*;

public class Cine {

	private static int files;
	private static int numSeientFila;
	private GestioButaques gestioButaques;

	public Cine() {
		this.gestioButaques = new GestioButaques();
		demanarDadesInicials();
	}

	public static void demanarDadesInicials() throws InputMismatchException {
		Scanner sc = new Scanner(System.in);
		boolean correcte = false;

		do {
			try {
				System.out.print("Introdueix el número de files del cinema: ");
				Cine.files = sc.nextInt();
				System.out.print("Introdueix el número de seients per fila: ");
				Cine.numSeientFila = sc.nextInt();
				if (Integer.class.isInstance(Cine.files) && Integer.class.isInstance(Cine.numSeientFila)) {
					correcte = true;
				}

			} catch (InputMismatchException e) {
				System.out.println("Les dades introduïdes no son correctes. ");
				System.out.println("Siusplau, torna a introduir-les. ");
				sc.nextLine();
			}
		} while (!correcte);
	}

	public void iniciar() {
		int menu;

		do {
			menu = menu();

			switch (menu) {
			case 1:
				mostrarButaques();
				break;
			case 2:
				mostrarButaquesPersona();
				break;
			case 3:
				reservarButaca();
				break;
			case 4:
				anularReserva();
				break;
			case 5:
				anularReservaPersona();
				break;
			case 0:
				sortir();
				break;
			}
		} while (menu != 0);

	}

	public int menu() {
		Scanner sc = new Scanner(System.in);
		boolean correcte = false;
		int menu = -1;

		do {
			try {
				System.out.println("\nEscull l'acció a realitzar: ");
				System.out.println("1. Mostrar totes les butaques reservades. ");
				System.out.println("2. Mostrar les butaques reservades per una persona. ");
				System.out.println("3. Reservar una butaca. ");
				System.out.println("4. Anular la reserva d'una butaca. ");
				System.out.println("5. Anul·lar totes les reserves d'una persona. ");
				System.out.println("0. Sortir. ");
				menu = sc.nextInt();
				if ((menu >= 0 || menu <= 5) && Integer.class.isInstance(menu)) {
					correcte = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Les dades introduïdes no son correctes. ");
				System.out.println("Siusplau, torna a introduir-les. ");
				sc.nextLine();
			}

		} while (!correcte && menu != 0);

		return menu;

	}

	public void mostrarButaques() {
		ArrayList<Butaca> butaques = gestioButaques.getButaques();

		if (butaques.size() == 0) {
			System.out.println("No hi ha butaques reservades. ");
		} else {
			for (Butaca butaca : butaques) {
				System.out.println(butaca);
			}
		}

	}

	public void mostrarButaquesPersona() {
		ArrayList<Butaca> butaques = gestioButaques.getButaques();

		String nomPersona = introduirPersona();

		for (Butaca butaca : butaques) {
			if (butaca.getNomPersona().equalsIgnoreCase(nomPersona)) {
				System.out.println(butaca);
			}
		}
	}

	public void reservarButaca() {
		ArrayList<Butaca> butaques = gestioButaques.getButaques();
		int numFila = introduirFila();
		int numSeient = introduirSeient();
		String nomPersona = introduirPersona();
		int posicioButaques = gestioButaques.cercarButaca(numFila, numSeient);

		try {

			if (posicioButaques == -1) {
				Butaca butacaAdd = new Butaca(numFila, numSeient, nomPersona);
				butaques.add(butacaAdd);
				System.out.println("S'ha afegit la butaca " + butacaAdd + " correctament. ");
			} else {
				throw new ExcepcioButacaOcupada("Aquesta butaca ja es troba reservada. ");
			}
		} catch (ExcepcioButacaOcupada e) {
			System.out.println("Aquesta butaca ja es troba reservada. ");
		}

	}

	public void anularReserva() {
		ArrayList<Butaca> butaques = gestioButaques.getButaques();
		int numFila = introduirFila();
		int numSeient = introduirSeient();
		int posicioButaques = gestioButaques.cercarButaca(numFila, numSeient);

		try {
			if (posicioButaques >= 0) {
				System.out.println(
						"S'ha anul·lat la reserva de la butaca " + butaques.get(posicioButaques) + " correctament. ");
				butaques.remove(posicioButaques);
			} else {
				throw new ExcepcioButacaLliure("Aquesta butaca no es troba reservada. ");
			}
		} catch (ExcepcioButacaLliure e) {
			System.out.println("Aquesta butaca no es troba reservada. ");
		}

	}

	public void anularReservaPersona() {
		ArrayList<Butaca> butaques = gestioButaques.getButaques();
		String nomPersona = introduirPersona();
		ListIterator<Butaca> li = butaques.listIterator();

		while (li.hasNext()) {
			Butaca butacaRemove = li.next();
			if (butacaRemove.getNomPersona().equalsIgnoreCase(nomPersona)) {
				System.out.println("S'ha anul·lat la reserva " + butacaRemove + ". ");
				li.remove();
			}
		}

		System.out.println("Totes les reserves de " + nomPersona + " han estat anul·lades. ");

	}

	public void sortir() {
		System.out.println("** Aplicació tancada ** ");

	}

	public int introduirFila() throws InputMismatchException {
		Scanner sc = new Scanner(System.in);
		int numFila = -1;
		boolean correcte = false;

		do {
			System.out.print("Introdueix el número de fila: ");
			try {
				numFila = sc.nextInt();
				if (Integer.class.isInstance(numFila) && numFila > 0 && numFila <= Cine.files) {
					correcte = true;
				} else if (numFila > Cine.files) {
					System.out.println("El número de fila no pot ser més gran que " + Cine.files + ". ");
					throw new ExcepcioFilaIncorrecta("El número de fila no coincideix amb les dimensions del cinema. ");
				} else if (numFila <= 0) {
					throw new ExcepcioFilaIncorrecta("El número de fila no coincideix amb les dimensions del cinema. ");
				}

			} catch (ExcepcioFilaIncorrecta e) {
				System.out.println("El número de fila no coincideix amb les dimensions del cinema. ");

			} catch (InputMismatchException e) {
				System.out.println("Error de format");
				sc.nextLine();

			}

		} while (!correcte);
		return numFila;
	}

	public int introduirSeient() throws InputMismatchException {
		Scanner sc = new Scanner(System.in);
		int numSeient = -1;
		boolean correcte = false;

		do {
			System.out.print("Introdueix el número de seient: ");
			try {
				numSeient = sc.nextInt();
				if (Integer.class.isInstance(numSeient) && numSeient > 0 && numSeient <= Cine.numSeientFila) {
					correcte = true;
				} else if (numSeient > Cine.numSeientFila) {
					System.out.println("El número de seient no pot ser més gran que " + Cine.numSeientFila + ". ");
					throw new ExcepcioSeientIncorrecte(
							"El número de seient no coincideix amb les dimensions del cinema. ");
				} else if (numSeient <= 0) {
					System.out.println("El número de seient no pot ser 0 o inferior. ");
					throw new ExcepcioSeientIncorrecte(
							"El número de seient no coincideix amb les dimensions del cinema. ");
				}

			} catch (ExcepcioSeientIncorrecte e) {
				System.out.println("El número de seient no coincideix amb les dimensions del cinema. ");
			} catch (InputMismatchException e) {
				System.out.println("Error de format");
				sc.nextLine();

			}

		} while (!correcte);
		return numSeient;

	}

	public String introduirPersona() {
		Scanner sc = new Scanner(System.in);
		String nomPersona = "";
		boolean correcte = false;

		do {
			System.out.print("Introdueix el nom de la persona: ");
			try {
				nomPersona = sc.nextLine();
				if (nomPersona.matches(".*[0-9].*")) {
					throw new ExcepcioNomPersonaIncorrecte("El nom de la persona no pot incloure números. ");
				} else if (String.class.isInstance(nomPersona) && nomPersona.length() > 0) {
					correcte = true;
				} else {
					System.out.println("El nom introduït no és correcte");
				}

			} catch (ExcepcioNomPersonaIncorrecte e) {
				System.out.println("El nom de la persona no pot incloure números. ");

			} catch (InputMismatchException e) {
				System.out.println("Error de format");
				sc.nextLine();

			}

		} while (!correcte);
		return nomPersona;

	}

}
