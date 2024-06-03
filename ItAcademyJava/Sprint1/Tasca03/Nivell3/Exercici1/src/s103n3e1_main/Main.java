package s103n3e1_main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import s103n3e1_gestion.*;

public class Main {

	public static void main(String[] args) {
		HashSet<Persona> personaList = personaDocReader();

		menu(personaList);
	}

	public static HashSet<Persona> personaDocReader() {
		HashSet<Persona> personaList = new HashSet<Persona>();

		try {
			File csvLlistat = new File("src\\s103n3e1_gestion\\llistat.csv");
			String line = null;
			BufferedReader reader = new BufferedReader(new FileReader(csvLlistat));

			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				String nom = parts[0].trim();
				String cognom = parts[1].trim();
				String dni = parts[2].trim();

				Persona personaAdd = new Persona(nom, cognom, dni);
				personaList.add(personaAdd);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Error de lectura del document CSV. ");
		}

		return personaList;
	}

	public static void menu(HashSet<Persona> personaList) {
		ArrayList<Persona> personaArray = new ArrayList<Persona>();
		byte option = menuOption();

		switch (option) {
		case 1:
			introduirPersona(personaList);
			break;
		case 2:
			mostrarNomAZ(personaList, personaArray);
			break;
		case 3:
			mostrarNomZA(personaList, personaArray);
			break;
		case 4:
			mostrarCognomAZ(personaList, personaArray);
			break;
		case 5:
			mostrarCognomZA(personaList, personaArray);
			break;
		case 6:
			mostrarDni19(personaList, personaArray);
			break;
		case 7:
			mostrarDni91(personaList, personaArray);
			break;
		case 0:
			sortir();
			break;
		}
	}

	public static byte menuOption() {
		Scanner sc = new Scanner(System.in);
		byte option = -1;

		do {
			try {
				System.out.println("\nEscriu el número de l'acció que vols dur a terme: ");
				System.out.println("1. Introduir persona ");
				System.out.println("2. Mostrar les persones ordenades per nom (A-Z) ");
				System.out.println("3. Mostrar les persones ordenades per nom (Z-A) ");
				System.out.println("4. Mostrar les persones ordenades per cognom (A-Z) ");
				System.out.println("5. Mostrar les persones ordenades per cognom (Z-A) ");
				System.out.println("6. Mostrar les persones ordenades per DNI (1-9) ");
				System.out.println("7. Mostrar les persones ordenades per DNI (9-1) ");
				System.out.println("0. Sortir");
				option = sc.nextByte();
			} catch (InputMismatchException e) {
				System.out.println("Error de format en la introducció de dades. ");
			} finally {
				if (option < 0 || option > 7) {
					System.out.println("El número introduït no és correcte.\n ");
					sc.nextLine();
				}
			}

		} while (option < 0 || option > 7);

		return option;
	}

	public static void sortir() {
		System.out.println("** S'ha finalitzat l'aplicació ** ");

	}

	public static void introduirPersona(HashSet<Persona> personaList) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Introdueix les dades de la persona que vols afegir a la llista: ");
		System.out.print("Nom: ");
		String nom = sc.nextLine();
		System.out.print("Cognom: ");
		String cognom = sc.nextLine();
		System.out.print("DNI: ");
		String dni = sc.nextLine();

		Persona personaAdd = buscarPersona(personaList, nom, cognom, dni);

		if (personaAdd != null) {
			personaList.add(personaAdd);
			System.out.println("S'ha afegit correctament: " + personaAdd.toString());
		} else {
			System.out.println("Aquesta persona ja existeix a la base de dades. ");
		}
		menu(personaList);
	}

	public static Persona buscarPersona(HashSet<Persona> personaList, String nom, String cognom, String dni) {

		Persona personaAdd = new Persona(nom, cognom, dni);
		for (Persona personaSearch : personaList) {
			if (personaAdd.equals(personaSearch)) {
				personaAdd = null;
				return personaAdd;
			}

		}
		return personaAdd;

	}

	public static void checkArray(HashSet<Persona> personaList, ArrayList<Persona> personaArray) {
		int i = 0;
		boolean found = false;
		for (Persona personaSearch : personaList) {
			i = 0;
			found = false;
			while (i < personaArray.size() && (found = false)) {
				if (personaSearch.equals(personaArray.get(i))) {
					found = true;
				} else {
					i++;
				}
			}
			if (!found) {
				personaArray.add(personaSearch);
			}
		}

	}

	public static void mostrarNomAZ(HashSet<Persona> personaList, ArrayList<Persona> personaArray) {

		ordenarNomAZ(personaList, personaArray);
		System.out.println("NOM		Cognom			DNI");
		for (Persona personaPrint : personaArray) {
			System.out.println(personaPrint.toString());
		}
		menu(personaList);
	}

	public static void ordenarNomAZ(HashSet<Persona> personaList, ArrayList<Persona> personaArray) {
		checkArray(personaList, personaArray);
		personaArray.sort(Comparator.comparing(Persona::getNom));
	}

	public static void mostrarNomZA(HashSet<Persona> personaList, ArrayList<Persona> personaArray) {

		ordenarNomZA(personaList, personaArray);
		System.out.println("NOM		Cognom			DNI");
		for (Persona personaPrint : personaArray) {
			System.out.println(personaPrint.toString());
		}
		menu(personaList);
	}

	public static void ordenarNomZA(HashSet<Persona> personaList, ArrayList<Persona> personaArray) {
		checkArray(personaList, personaArray);
		personaArray.sort(Comparator.comparing(Persona::getNom));
		Collections.reverse(personaArray);
	}

	public static void mostrarCognomAZ(HashSet<Persona> personaList, ArrayList<Persona> personaArray) {

		ordenarCognomAZ(personaList, personaArray);
		System.out.println("NOM		Cognom			DNI");
		for (Persona personaPrint : personaArray) {
			System.out.println(personaPrint.toString());
		}
		menu(personaList);
	}

	public static void ordenarCognomAZ(HashSet<Persona> personaList, ArrayList<Persona> personaArray) {
		checkArray(personaList, personaArray);
		personaArray.sort(Comparator.comparing(Persona::getCognom));
	}

	public static void mostrarCognomZA(HashSet<Persona> personaList, ArrayList<Persona> personaArray) {
		
		ordenarCognomZA(personaList, personaArray);
		System.out.println("NOM		Cognom			DNI");
		for (Persona personaPrint : personaArray) {
			System.out.println(personaPrint.toString());
		}
		menu(personaList);
	}

	public static void ordenarCognomZA(HashSet<Persona> personaList, ArrayList<Persona> personaArray) {
		checkArray(personaList, personaArray);
		personaArray.sort(Comparator.comparing(Persona::getCognom));
		Collections.reverse(personaArray);
	}

	public static void mostrarDni19(HashSet<Persona> personaList, ArrayList<Persona> personaArray) {
		ordenarDni19(personaList, personaArray);
		System.out.println("NOM		Cognom			DNI");
		for (Persona personaPrint : personaArray) {
			System.out.println(personaPrint.toString());
		}
		menu(personaList);
	}

	public static void ordenarDni19(HashSet<Persona> personaList, ArrayList<Persona> personaArray) {
		checkArray(personaList, personaArray);
		personaArray.sort(Comparator.comparing(Persona::getDni));
	}

	public static void mostrarDni91(HashSet<Persona> personaList, ArrayList<Persona> personaArray) {
		ordenarDni91(personaList, personaArray);
		System.out.println("NOM		Cognom			DNI");
		for (Persona personaPrint : personaArray) {
			System.out.println(personaPrint.toString());
		}
		menu(personaList);
	}

	public static void ordenarDni91(HashSet<Persona> personaList, ArrayList<Persona> personaArray) {
		checkArray(personaList, personaArray);
		personaArray.sort(Comparator.comparing(Persona::getDni));
		Collections.reverse(personaArray);
	}

}
