package s301n2;

import java.util.Scanner;

public class Menu {

	public static void menuRun() {

		int option = 0;

		try (Scanner sc = new Scanner(System.in)) {
			do {
				option = menuOption(sc);
				switch (option) {
				case 1 -> addContact(sc);
				// case 2 -> showList();
				}

			} while (option != 0);
		} catch (Exception e) {
			System.out.println("Data entry error. ");
		}

		menuClose();

	}

	public static void menuClose() {
		System.out.println("Terminating program execution... ");
	}

	public static int menuOption(Scanner sc) {
		int option = -1;

		System.out.println(
				"\nEnter the number of your next desired action: \n1. Add a new contact \n2. Show contact list ");
		do {
			option = sc.nextInt();
			
		} while (option == -1);

		return option;
	}

	public static void addContact(Scanner sc) {
		int country = selectCountry(sc);
		int prefix = setCountryPrefix(country);
		
		Manager manager = Manager.configureManager(prefix);
		manager.setContactEntry(sc);
			
		

	}

	public static int selectCountry(Scanner sc) {
		int country = 0;

		do {
			System.out.println("Select the country number of new contact: \n1. Spain \n2. Portugal ");
			country = sc.nextInt();

		} while (country <1 && country >2);
		
		return country;
	}
	
	public static int setCountryPrefix(int country) {
		int prefix = 0;
		
		switch (country) {
		case 1 -> prefix = 34;
		case 2 -> prefix = 351;
		
		}
		
		return prefix;
	}
	
	
	
	

}
