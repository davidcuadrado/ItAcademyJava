package s108n1e6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortByLength {

	public static void main(String[] args) {

		List<Object> list = List.of("oso", 5, "elefante", 24, 567, 0753234, "lobo", "girafa");
		
		List<String> stringList = convertList(list);
		
		stringList.sort(Comparator.comparingInt(String::length));
		
		stringList.forEach(System.out::println);
	}

	public static List<String> convertList(List<Object> list) {

		List<String> stringList = new ArrayList<String>();

		list.forEach(s -> stringList.add(s.toString()));

		return stringList;
	}

}
