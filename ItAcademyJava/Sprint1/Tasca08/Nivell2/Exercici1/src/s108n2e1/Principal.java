package s108n2e1;

import java.util.List;
import java.util.stream.Collectors;

public class Principal {

	public static void main(String[] args) {
		
		List<String> nameList = List.of("Pere", "Joaquim", "Anna", "Arnau", "Amàlia","Francesc", "Ander", "Ana", "Apol·loni");
		
		List<String> començaATresLletres = screenNames(nameList);
		
		començaATresLletres.forEach(System.out::println);

	}
	
	public static List<String> screenNames(List<String> nameList){
		
		Predicate<String> empeizaPorA =  name ->  name.charAt(0) == 'A';
		Predicate<String> tieneLenght3 = name -> name.length() == 3;
		
		
		return nameList.stream().filter(empeizaPorA.and(tieneLenght3)).collect(Collectors.toList());
		
	}

}
