package s105n1e1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class Alfabetico {

	static String directory = "";
	static File directoryFile = new File(Alfabetico.directory);

	public static void iniciar() {

		do {
			directoryInput();
			directoryFile = new File(Alfabetico.directory);

			if (!directoryFile.exists() || !directoryFile.canRead()) {
				System.out.println("Error en la ruta del directorio.");
			}

		} while ((!directoryFile.exists() || !directoryFile.canRead()));

	}

	public static void directoryInput() {
		try (Scanner sc = new Scanner(System.in);){
			System.out.println("Introduzca el directorio: ");
			directory = sc.nextLine();
		} catch (NoSuchElementException e) {
			System.out.println("Error en la introducció de dades per teclat. ");
		}
	}

	public static void ordenarDirectorio(String directory) {

		try (BufferedReader bf = new BufferedReader(new FileReader(directory))) {

			StringBuilder wordStringBuilder = new StringBuilder(bf.lines().collect(Collectors.joining()));
			String wordString = wordStringBuilder.toString().trim();
			wordString = StringUtils.stripAccents(wordString);
			String[] wordArray = wordString.split("[\\s+ , ; . : _ \\- / ( )]");
			List<String> wordList = Arrays.asList(wordArray);

			wordList = wordList.stream().sorted(String.CASE_INSENSITIVE_ORDER).toList();

			wordList.forEach(System.out::println);

		} catch (IOException e) {
			System.out.println("No s'ha trobat l'arxiu especificat. ");
		}
	}
}
