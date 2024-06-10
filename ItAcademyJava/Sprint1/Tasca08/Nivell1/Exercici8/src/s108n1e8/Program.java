package s108n1e8;

public class Program {

	public static void main(String[] args) {

   String stringToReverse = "A new string ready to be reversed."
		
		Reverser reverser = () -> new StringBuilder(new String(stringToReverse)).reverse().toString();

String stringReversed = reverser.reverse(stringToReverse);

System.out.println(stringReversed);
			
			
		} );

	}

}
