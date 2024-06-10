package s108n1e8;

public class Program {

	public static void main(String[] args) {

		String stringToReverse = "A new string ready to be reversed.";

		Reverser reverser = str -> new StringBuilder(str).reverse().toString();
		
		System.out.println(reverser.reverse(stringToReverse));

	}

}
