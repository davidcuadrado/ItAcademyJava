package s108n2e1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Principal {

	public static void main(String[] args) {
		
		List<String> nameList = Arrays.asList("Pere", "Joaquim", "Anna", "Arnau", "Amàlia","Francesc", "Ander", "Ana", "Apol·loni");
		
		List<String> començaATresLletres = screenNames(nameList);
		
		començaATresLletres.forEach(System.out::println);

	}
	
	public static List<String> screenNames(List<String> nameList){
		
		List<String> nameListA = nameList.stream().filter(name -> ( name.charAt(0) == 'A') ).collect(Collectors.toList());
		List<String> començaATresLletres = nameListA.stream().filter(name -> (name.length() == 3)).collect(Collectors.toList());
		
		return començaATresLletres;
	}

}
