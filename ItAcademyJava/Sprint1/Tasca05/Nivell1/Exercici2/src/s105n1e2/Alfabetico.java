package s105n1e2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;

public class Alfabetico {

	static String directory = "D:\\00proyectos\\S105N1E2";
	static File directoryFile = new File(Alfabetico.directory);
	
	public static void iniciar() {
		// añadir introducción de datos directorio mediante teclado.
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
}