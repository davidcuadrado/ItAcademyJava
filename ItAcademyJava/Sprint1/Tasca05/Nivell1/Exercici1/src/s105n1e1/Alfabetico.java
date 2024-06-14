package s105n1e1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Alfabetico {

	final static String directory = "D:\\00proyectos\\S105N1E1\\src\\s105n1e1_import\\toOrder.txt";

	public static void ordenarDirectorio(String directory) {

		try (BufferedReader bf = new BufferedReader(new FileReader(directory))) {

			StringBuilder wordStringBuilder = new StringBuilder(bf.lines().collect(Collectors.joining()));
			String wordString = wordStringBuilder.toString().trim();
			String[] wordArray = wordString.split("[\\s+ , ; . : _ \\- / ( )]");
			List<String> wordList = Arrays.asList(wordArray);

			wordList = wordList.stream().sorted(String.CASE_INSENSITIVE_ORDER).toList();

			wordList.forEach(System.out::println);

		} catch (IOException e) {
			System.out.println("No s'ha trobat l'arxiu especificat. ");
		}
	}
}
