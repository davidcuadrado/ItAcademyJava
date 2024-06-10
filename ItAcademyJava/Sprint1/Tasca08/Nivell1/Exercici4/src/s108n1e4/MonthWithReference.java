package s108n1e4;

import java.util.Arrays;
import java.util.List;

public class MonthWithReference {

	public static void main(String[] args) {

		List<String> monthList = Arrays.asList("gener", "febrer", "març", "abril", "maig", "juny", "juliol", "agost",
				"setembre", "octubre", "novembre", "desembre");
		
		printMonth(monthList);
		
	}
	
	public static void printMonth(List<String> monthList) {
		
		monthList.forEach(System.out::println);
	}

}
