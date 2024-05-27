package s103n1e3_main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		HashMap<String, String> paisCapital = hashMapCountries();
		String nom = demanarNom();
		gameExe(nom, paisCapital);

	}

	
	
	
	public static HashMap<String, String> hashMapCountries() {
		HashMap<String, String> hashMap = new HashMap<String, String>();

		try {
			File countries = new File("src\\s103n1e3_countries\\countries.txt");
			String line = null;
			BufferedReader reader = new BufferedReader(new FileReader(countries));

			while ((line = reader.readLine()) != null) {

				String[] parts = line.split(" ");
				String pais = parts[0].trim();
				String capital = parts[1].trim();

				if (!pais.equals("") && !capital.equals("")) {
					hashMap.put(pais, capital);
				}
			}
			reader.close();

		} catch (IOException e) {
			System.out.println("No s'ha trobat l'arxiu a la direcció proposada. ");
		}
		return hashMap;
	}

	public static String demanarNom() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introdueix el teu nom: ");
		String nom = sc.nextLine();
		return nom;
	}

	public static void generarListPais(HashMap<String, String> paisCapital, ArrayList<String> pais) {
		for (String paisAdd : paisCapital.keySet()) {
			pais.add(paisAdd);
		}
	}

	public static void generarListCapital(HashMap<String, String> paisCapital, ArrayList<String> capital) {
		for (String capitalAdd : paisCapital.values()) {
			capital.add(capitalAdd);
		}
	}

	public static void gameExe(String nom, HashMap<String, String> paisCapital) {
		Scanner sc = new Scanner(System.in);
		int contadorIntents = 0;
		final int intentsMax = 10;
		int puntuacio = 0;
		ArrayList<String> pais = new ArrayList<String>();
		generarListPais(paisCapital, pais);
		ArrayList<String> capital = new ArrayList<String>();
		generarListCapital(paisCapital, capital);

		while (contadorIntents < intentsMax) {
			int numMap = (int) (Math.random() * paisCapital.size() + 0);
			System.out.println("El país és: " + pais.get(numMap) + ". ");
			System.out.println("Quina és la seva capital?");
			String capitalInput = sc.nextLine();
			if (capitalInput.equalsIgnoreCase(capital.get(numMap))) {
				puntuacio += 1;
			}

			contadorIntents += 1;
		}
		generateResult(nom, puntuacio);

	}

	public static void generateResult(String nom, int puntuacio) {
		try {
		FileWriter result = new FileWriter("src\\s103n1e3_countries\\result.txt");
		result.write("Jugador: "+nom+"\nPuntuació: "+puntuacio);
		result.close();
		System.out.println("S'ha creat l'arxiu correctament. ");
		} catch(IOException e) {
			System.out.println("Error en la creació de l'arxiu. ");
		}

	}

}
