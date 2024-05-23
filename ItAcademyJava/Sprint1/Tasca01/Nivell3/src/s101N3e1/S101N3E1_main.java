package s101N3e1;

import java.util.ArrayList;
import java.util.Scanner;
import noticies.*;

public class S101N3E1_main {

	public static void main(String[] args) {

		boolean sortir = false;
		ArrayList<Redactor> listaRedactores = new ArrayList<Redactor>();

		do {
			switch (menu()) {
			case 1:
				introduirRedactor(listaRedactores);
				break;
			case 2:
				eliminarRedactor(listaRedactores);
				break;
			case 3:
				introduirNoticia(listaRedactores);
				break;
			case 4:
				eliminarNoticia(listaRedactores);
				break;
			case 5:
				mostrarNoticiesRedactor(listaRedactores);
				break;
			case 6:
				calcularPuntuacioNoticia(listaRedactores);
				break;
			case 7:
				calcularPreuNoticia(listaRedactores);
				break;

			}
		} while (!sortir);
	}

	public static byte menu() {
		Scanner entrada = new Scanner(System.in);
		byte opcio;
		final byte MINIMO = 1;
		final byte MAXIMO = 7;

		do {
			System.out.println("\nMENú PRINCIPAL");
			System.out.println("1. Introduir redactor. ");
			System.out.println("2. Eliminar redactor. ");
			System.out.println("3. Introduir notícia a un redactor. ");
			System.out.println("4. Eliminar notícia. ");
			System.out.println("5. Mostrar totes les notícies per redactor.  ");
			System.out.println("6. Calcular puntuació de la noticia. ");
			System.out.println("7. Calcular preu-notícia");
			opcio = entrada.nextByte();
			if (opcio < MINIMO || opcio > MAXIMO) {
				System.out.println("Escull una opció vàlida");
			}
		} while (opcio < MINIMO || opcio > MAXIMO);
		return opcio;
	}

	public static void introduirRedactor(ArrayList<Redactor> listaRedactores) {
		String dni = demanarDni();
		Redactor buscarRedactor = buscarRedactor(listaRedactores, dni);

		if (buscarRedactor != null) {
			System.out.println("Aquest redactor ja existeix. ");
		} else {
			String nom = demanarNom();
			Redactor redactorAdd = new Redactor(nom, dni);
			listaRedactores.add(redactorAdd);
			System.out.println("S'ha afegit el redactor amb DNI " + redactorAdd.getDni() + " a la base de dades. ");

		}
	}

	public static void eliminarRedactor(ArrayList<Redactor> listaRedactores) {
		String dni = demanarDni();
		Redactor buscarRedactor = buscarRedactor(listaRedactores, dni);
		if (buscarRedactor == null) {
			System.out.println("No existeix un redactor amb DNI " + dni + ". ");
		} else {
			listaRedactores.remove(buscarRedactor);
			System.out.println("S'ha eliminat el redactor amb DNI " + dni + ". ");
		}
	}

	public static void introduirNoticia(ArrayList<Redactor> listaRedactores) {

		String titular = titularNoticia();
		String dni = demanarDni();
		Redactor redactor = buscarRedactor(listaRedactores, dni);

		if (redactor != null) {
			boolean existeix = buscarNoticiaRedactor(redactor, titular);
			if (existeix) {
				System.out.println("Ja existeix una noticia amb aquest titular. ");
			} else {
				byte tipusNoticia = tipusNoticia();
				switch (tipusNoticia) {
				case 1:
					afegirFutbol(redactor, titular);
					break;
				case 2:
					afegirBasquet(redactor, titular);
					break;
				case 3:
					afegirTenis(redactor, titular);
					break;
				case 4:
					afegirF1(redactor, titular);
					break;
				case 5:
					afegirMotociclisme(redactor, titular);
					break;
				}
			}
		} else {
			System.out.println("Aquest redactor no existeix. ");
		}

	}

	public static void eliminarNoticia(ArrayList<Redactor> listaRedactores) {
		String titular = titularNoticia();
		String dni = demanarDni();
		Redactor redactor = buscarRedactor(listaRedactores, dni);

		if (redactor != null) {
			int posicio = buscarPosicioNoticia(redactor, titular);

			if (posicio < 0) {
				System.out.println("No existeix aquesta noticia per eliminar. ");
			} else {
				redactor.noticiesLlista.remove(posicio);
				System.out.println("S'ha eliminat la noticia correctament. ");
			}
		} else {
			System.out.println("Aquest redactor no existeix. ");
		}
	}

	public static void mostrarNoticiesRedactor(ArrayList<Redactor> listaRedactores) {
		String dni = demanarDni();
		Redactor redactor = buscarRedactor(listaRedactores, dni);

		if (redactor == null) {
			System.out.println("No existeix un redactor amb aquest DNI. ");
		} else {
			printNoticiesRedactor(redactor);
		}

	}

	public static void calcularPuntuacioNoticia(ArrayList<Redactor> listaRedactores) {
		String titular = titularNoticia();
		String dni = demanarDni();
		Redactor redactor = buscarRedactor(listaRedactores, dni);
		
		if (redactor != null) {
		int posicio = buscarPosicioNoticia(redactor, titular);

		if (posicio < 0) {
			System.out.println("No s'ha trobat la noticia. ");
		} else {
			byte puntuacio = redactor.getNoticiesLlista().get(posicio).calcularPuntuacio();
			redactor.getNoticiesLlista().get(posicio).setPuntuacio(puntuacio);
			System.out.println("La puntuació d'aquesta noticia és " + puntuacio + ". ");
		}
		} else {
			System.out.println("Aquest redactor no existeix. ");
		}

	}

	public static void calcularPreuNoticia(ArrayList<Redactor> listaRedactores) {
		String titular = titularNoticia();
		String dni = demanarDni();
		Redactor redactor = buscarRedactor(listaRedactores, dni);
		
		if (redactor != null) {
		int posicio = buscarPosicioNoticia(redactor, titular);

		if (posicio < 0) {
			System.out.println("No s'ha trobat la noticia. ");
		} else {
			short preu = redactor.getNoticiesLlista().get(posicio).calcularPreuNoticia();
			redactor.getNoticiesLlista().get(posicio).setPreu(preu);
			System.out.println("El preu d'aquesta noticia és " + preu + ". ");
		}
		} else {
			System.out.println("Aquest redactor no existeix. ");
		}

	}

	// métodos auxiliares

	public static String demanarDni() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introdueix el DNI del redactor: ");
		String dni = sc.nextLine();

		return dni;
	}
	
	public static String demanarNom() {
			Scanner sc = new Scanner(System.in);

			System.out.print("Introdueix el nom del redactor: ");
			String nom = sc.nextLine();

			return nom;
	}

	public static Redactor buscarRedactor(ArrayList<Redactor> listaRedactores, String dni) {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		Redactor buscarRedactor = null;

		while (i < listaRedactores.size() && buscarRedactor == null) {
			if (listaRedactores.get(i).getDni().equalsIgnoreCase(dni)) {
				buscarRedactor = listaRedactores.get(i);
			} else {
				i++;
			}
		}
		return buscarRedactor;
	}

	public static String titularNoticia() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introdueix el títol de la noticia: ");
		String titular = sc.nextLine();

		return titular;
	}

	public static byte tipusNoticia() {
		Scanner sc = new Scanner(System.in);
		byte tipusNoticia;

		do {
			System.out.println("Introdueix el tipus de noticia que vols afegir: ");
			System.out.println("1. Futbol ");
			System.out.println("2. Bàsquet ");
			System.out.println("3. Tenis ");
			System.out.println("4. F1 ");
			System.out.println("5. Motociclisme ");
			tipusNoticia = sc.nextByte();
		} while (tipusNoticia < 1 && tipusNoticia > 5);
		sc.nextLine();

		return tipusNoticia;
	}

	private static boolean buscarNoticiaRedactor(Redactor redactor, String titular) {
		int i = 0;
		boolean existe = false;

		while (i < redactor.noticiesLlista.size()
				&& (redactor.noticiesLlista.get(i).getTitular().equalsIgnoreCase(titular))) {
			if (redactor.noticiesLlista.get(i).getTitular().equalsIgnoreCase(titular)) {
				existe = true;
			} else {
				i++;
			}

		}
		return existe;
	}

	private static void afegirFutbol(Redactor redactor, String titular) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introdueix la competició de la que tracta la noticia: ");
		String competicio = sc.nextLine();
		System.out.print("Introdueix el club del que tracta la noticia: ");
		String club = sc.nextLine();
		System.out.print("Introdueix el jugador del que tracta la noticia: ");
		String jugador = sc.nextLine();

		Futbol futbolAdd = new Futbol(titular, competicio, club, jugador);

		short preu = futbolAdd.calcularPreuNoticia();
		futbolAdd.setPreu(preu);
		byte puntuacio = futbolAdd.calcularPuntuacio();
		futbolAdd.setPuntuacio(puntuacio);

		redactor.noticiesLlista.add(futbolAdd);
		System.out.println("La noticia s'ha afegit correctament. ");

	}

	private static void afegirBasquet(Redactor redactor, String titular) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introdueix la competició de la que tracta la noticia: ");
		String competicio = sc.nextLine();
		System.out.print("Introdueix el club del que tracta la noticia: ");
		String club = sc.nextLine();

		Basquet basquetAdd = new Basquet(titular, competicio, club);

		short preu = basquetAdd.calcularPreuNoticia();
		basquetAdd.setPreu(preu);
		byte puntuacio = basquetAdd.calcularPuntuacio();
		basquetAdd.setPuntuacio(puntuacio);

		redactor.noticiesLlista.add(basquetAdd);
		System.out.println("La noticia s'ha afegit correctament. ");

	}

	private static void afegirTenis(Redactor redactor, String titular) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introdueix la competició de la que tracta la noticia: ");
		String competicio = sc.nextLine();
		System.out.print("Introdueix el tenista del que tracta la noticia: ");
		String tenista = sc.nextLine();

		Tenis tenisAdd = new Tenis(titular, competicio, tenista);

		short preu = tenisAdd.calcularPreuNoticia();
		tenisAdd.setPreu(preu);
		byte puntuacio = tenisAdd.calcularPuntuacio();
		tenisAdd.setPuntuacio(puntuacio);

		redactor.noticiesLlista.add(tenisAdd);
		System.out.println("La noticia s'ha afegit correctament. ");

	}

	private static void afegirF1(Redactor redactor, String titular) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introdueix l'escuderia de la que tracta la noticia: ");
		String escuderia = sc.nextLine();

		F1 f1Add = new F1(titular, escuderia);

		short preu = f1Add.calcularPreuNoticia();
		f1Add.setPreu(preu);
		byte puntuacio = f1Add.calcularPuntuacio();
		f1Add.setPuntuacio(puntuacio);

		redactor.noticiesLlista.add(f1Add);
		System.out.println("La noticia s'ha afegit correctament. ");

	}

	private static void afegirMotociclisme(Redactor redactor, String titular) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Introdueix l'equip del que tracta la noticia: ");
		String equip = sc.nextLine();

		Motociclisme motociclismeAdd = new Motociclisme(titular, equip);

		short preu = motociclismeAdd.calcularPreuNoticia();
		motociclismeAdd.setPreu(preu);
		byte puntuacio = motociclismeAdd.calcularPuntuacio();
		motociclismeAdd.setPuntuacio(puntuacio);

		redactor.noticiesLlista.add(motociclismeAdd);
		System.out.println("La noticia s'ha afegit correctament. ");

	}

	private static int buscarPosicioNoticia(Redactor redactor, String titular) {
		int posicio = -1;
		int i = 0;

		while (i < redactor.noticiesLlista.size()
				&& (redactor.noticiesLlista.get(i).getTitular().equalsIgnoreCase(titular))) {
			if (redactor.noticiesLlista.get(i).getTitular().equalsIgnoreCase(titular)) {
				posicio = i;
				return posicio;
			} else {
				i++;
			}
		}
		return posicio;
	}

	public static void printNoticiesRedactor(Redactor redactor) {

		for (int i = 0; i < redactor.noticiesLlista.size(); i++) {
			System.out.println((i + 1) + ". " + redactor.getNoticiesLlista().get(i).getTitular() + ". ");
		}
	}

}
