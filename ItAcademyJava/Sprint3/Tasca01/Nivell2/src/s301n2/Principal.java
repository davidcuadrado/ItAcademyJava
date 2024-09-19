package s301n2;

public class Principal {

	public static void main(String[] args) {
		

		welcome();
		
		Menu.menuRun();
		
		goodbye();

	}

	private static void welcome() {
		System.out.println("** Welcome to your international contact list **");
	}
	
	private static void goodbye() {
		System.out.println("\n** Your contact list is now closed **");
	}

}