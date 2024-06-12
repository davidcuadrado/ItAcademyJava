package s108n1e1;

import java.util.List;
import java.util.stream.Collectors;

public class ListaO {

	public static void main(String[] args) {

		List<String> wordList = List.of("oso", "cabra", "elefante", "lobo", "pelicano", "lobo");
		List<String> wordListO = screenO(wordList);

		for (String wordO : wordListO) {
			System.out.println(wordO);
		}

	}

	public static List<String> screenO(List<String> wordList) {

		List<String> wordListO = wordList.stream().filter(word -> word.contains("o")).toList();

		return wordListO;
	}
}
