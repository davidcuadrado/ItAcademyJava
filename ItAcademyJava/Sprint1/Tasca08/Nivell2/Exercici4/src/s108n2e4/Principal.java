package s108n2e4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		List<Object> mixedList = List.of("fire", "earth", 5, 18, "day", 9, "water", 7, "night", "wind");

		System.out.println("Apartado 1: \n");
		mixedList = orderListAlphabetically(mixedList);
		mixedList.forEach(System.out::println);
		// se podría filtrar para que 18 no aparezca el primero?

		System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _\nApartado 2: \n");
		List<Object> mixedListAlphabeticallyAndE = orderListAlphabeticallyAndE(mixedList);
		mixedListAlphabeticallyAndE.forEach(System.out::println);
		
		System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _\nApartado 3: \n");
		List<Object> mixedListATo4 = mixedListReplaceATo4(mixedList);
		mixedListATo4.forEach(System.out::println);
		
		System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _\nApartado 4: \n");
		List<Object> mixedListNum = mixedListToNum(mixedList);
		mixedListNum.forEach(System.out::println);

	}
	
	

	public static List<Object> orderListAlphabetically(List<Object> mixedList) {

		return mixedList.stream().sorted(Comparator.comparing(Object::toString)).toList();
	}
	
	

	public static List<Object> orderListAlphabeticallyAndE(List<Object> mixedList) {

		List<String> mixedListToString = convertListToString(mixedList);

		List<String> mixedListStringE = mixedListToString.stream().filter(word -> word.contains("e")).toList();
		List<String> mixedListStringNotE = mixedListToString.stream().filter(word -> !(word.contains("e"))).toList();

		List<Object> mixedListAlphabeticallyAndE = new ArrayList<Object>();
		mixedListStringE.forEach(n -> mixedListAlphabeticallyAndE.add(n));
		mixedListStringNotE.forEach(n -> mixedListAlphabeticallyAndE.add(n));

		return mixedListAlphabeticallyAndE;
	}
	
	public static List<Object> mixedListReplaceATo4(List<Object> mixedList){
		
		List<String> mixedListToString = convertListToString(mixedList);
		mixedListToString = mixedListToString.stream().map(n -> n.replace('a', '4')).toList();
		List<Object> mixedListATo4 = new ArrayList<Object>();
		mixedListToString.forEach(n -> mixedListATo4.add(n));
		
		return mixedListATo4;
	}
	
	public static List<Object> mixedListToNum(List<Object> mixedList){
		
		List<String> mixedListToString = convertListToString(mixedList);
		List<Object> mixedListNum = new ArrayList<Object>();
		mixedListToString = mixedListToString.stream().filter(n -> n.matches("\\d+")).toList();
		mixedListToString.forEach(n -> mixedListNum.add(n));
		
		return mixedListNum;
	}
	
	

	public static List<String> convertListToString(List<Object> mixedList) {

		List<String> mixedListString = new ArrayList<String>();

		mixedList.forEach(s -> mixedListString.add(s.toString()));
		
		return mixedListString;
	}

}
