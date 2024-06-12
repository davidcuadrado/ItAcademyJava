package s108n2e2;

import java.util.List;


public class Principal {

	public static void main(String[] args) {
		
		List<Integer> numList = List.of(3, 55, 44, 95, 48, 22);
		
		String formatedString = numSeparator(numList);
		
		System.out.println(formatedString);

	}
	
	public static String numSeparator(List<Integer>numList) {
		
		List<String> formatingString = numList.stream().map(num -> (num % 2 == 0 ? "o"+num : "e" +num))..toList();
		String formatedString = String.join(", ", formatingString);
		
		return formatedString;
		
	}

}
