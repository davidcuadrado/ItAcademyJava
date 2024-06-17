package s105n1e4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;

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

		try (Scanner sc = new Scanner(System.in);) {
			System.out.println("Introduzca el directorio: ");
			directory = sc.nextLine();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
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

	public static void listarArbolDirectorio(File directoryFile) {

		try {

			List<File> directoryList = List.of(directoryFile.listFiles());
			directoryList = directoryList.stream().sorted().toList();
			SimpleDateFormat lastModDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			for (File file : directoryList) {
				if (file.isFile()) {
					System.out.println("(F) " + file.getName() + " - Last Modification:"
							+ lastModDate.format(file.lastModified()));
				} else {
					System.out.println("(D) " + file.getName() + " - Last Modification: "
							+ lastModDate.format(file.lastModified()));
					listarArbolDirectorio(file);

				}
			}
		} catch (NullPointerException e) {
			System.out.println("Error en la ruta del directori. ");
			e.printStackTrace();
		}

	}

	public static void txtArbolDirectorio(File directoryFile) {

		File nuevotxt = new File(directory + "\\directory_tree_file.txt");

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nuevotxt, true))) {

			List<File> directoryList = List.of(directoryFile.listFiles());
			directoryList = directoryList.stream().sorted().toList();
			SimpleDateFormat lastModDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			for (File file : directoryList) {
				if (file.isFile()) {
					writer.write("(F) " + file.getName() + " - Last Modification:"
							+ lastModDate.format(file.lastModified()) + "\n");
				} else {
					writer.write("(D) " + file.getName() + " - Last Modification: "
							+ lastModDate.format(file.lastModified()) + "\n");
					txtArbolDirectorio(file);

				}
			}

		} catch (IOException e) {
			System.out.println("Error en la ruta del directori. ");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("El volumen de directorios es demasiado grande. ");
		}
	}

	public static void readtxt(File directoryFile) {

		if (directoryFile.isFile() && directoryFile.getName().endsWith(".txt")) {
			try (BufferedReader reader = new BufferedReader(new FileReader(directory))) {
				String lineaPrint = reader.readLine();
				do {
					System.out.println(lineaPrint);
				} while ((lineaPrint = reader.readLine() ) != null);
			} catch (IOException e) {
				System.out.println("Error en la ruta del directorio introducida");
			}
		} else {
			System.out.println("El directori no té format .txt");
		}
	}

}
