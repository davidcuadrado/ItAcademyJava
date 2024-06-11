package s108n1e3;

import java.util.Arrays;
import java.util.List;

public class Month {

	public static void main(String[] args) {

		List<String> monthList = Arrays.asList("gener", "febrer", "març", "abril", "maig", "juny", "juliol", "agost",
				"setembre", "octubre", "novembre", "desembre");
		
		printMonth(monthList);
		
	}
	
	public static void printMonth(List<String> monthList) {
		
		monthList.forEach(s -> System.out.println(s));
	}

}
