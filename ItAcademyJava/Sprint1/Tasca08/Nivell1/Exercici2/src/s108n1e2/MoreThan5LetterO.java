package s108n1e2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MoreThan5LetterO {

	public static void main(String[] args) {

		List<String> wordList = Arrays.asList("oso", "cabra", "elefante", "lobo", "pelicano", "lobo");
		List<String> wordListOAndMoreThanFiveLetters = screenO(wordList);

		for (String wordOAndMore : wordListOAndMoreThanFiveLetters) {
			System.out.println(wordOAndMore);
		}

	}

	public static List<String> screenO(List<String> wordList) {

		List<String> wordListO = wordList.stream().filter(word -> word.contains("o")).collect(Collectors.toList());
		List<String> wordListOAndMoreThanFiveLetters = wordListO.stream().filter( word -> (word.length() > 5)).collect(Collectors.toList());

		return wordListOAndMoreThanFiveLetters;
	}

}
