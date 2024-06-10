package s108n1e7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReverseLength {

	public static void main(String[] args) {

		List<Object> list = Arrays.asList("oso", 5, "elefante", 24, 567, 0753234, "lobo", "girafa");
		
		
		List<String> stringList = convertList(list);
		
		stringList.sort(Comparator.comparingInt(String::length));
		stringList.sort( (s1, s2) -> Integer.compare(s2.length(), s1.length()) );
		
		stringList.forEach(System.out::println);
	}

	public static List<String> convertList(List<Object> list) {

		List<String> stringList = new ArrayList<String>();

		list.forEach((s) -> stringList.add(s.toString()));

		return stringList;
	}

}
