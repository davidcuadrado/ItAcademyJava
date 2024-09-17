package s301n2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static boolean menuRun() {

		int option = -1;

		try (Scanner sc = new Scanner(System.in)) {
			do {
				option = menuOption(sc);
				if (option >= 0 && option <= 2) {
					switch (option) {
					case 1 -> addContact(sc);
					case 2 -> showList();
					case 0 -> System.out.println("Your contact list will close soon. ");
					}
				} else {
					System.out.println("Invalid menu option. ");
				}

			} while (option != 0);
		} catch (InputMismatchException i) {
			System.out.println("Invalid data entry. ");
			option= 0;

		} catch (Exception e) {
			System.out.println("An unresolved exception happend. Relaunch needed. ");
			option = 0;
		}
		menuClose();
		if (option == 0) {
			return true;
		} else {
			return false;
		}

	}

	public static void menuClose() {
		System.out.println("Terminating program execution... ");
	}

	public static int menuOption(Scanner sc) throws InputMismatchException {

		System.out.println(
				"\nEnter the number of your next desired action: \n1. Add a new contact \n2. Show contact list \n0. Exit application");
		
		int option = sc.nextInt();

		return option;
	}

	public static void addContact(Scanner sc) {
		int country = selectCountry(sc);
		int prefix = setCountryPrefix(country);

		Manager manager = Manager.configureManager(sc, prefix);
		manager.setContactEntry();

	}

	public static int selectCountry(Scanner sc) {
		int country = 0;
		
		System.out.println("Select the country number of new contact: \n1. Spain \n2. Portugal ");

		do {
			;
			country = sc.nextInt();
			sc.nextLine();
			
			if (!(country >= 1 && country <= 2)) {
				System.out.println("Incorrect country option. Please, try again: \n1. Spain \n2. Portugal");
			}

		} while (!(country >= 1 && country <= 2));

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

	private static void showList() {

		System.out.println("Showing the contact list. ");
	}

}
