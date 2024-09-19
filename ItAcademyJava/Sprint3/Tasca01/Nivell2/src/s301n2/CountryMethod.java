package s301n2;

import java.util.Scanner;

public class CountryMethod {
	
	public static String inputStreet(Scanner sc) {
		
		String street;
		System.out.print("Road/Street: ");
		street = sc.nextLine();
		
		return street;
	}

	public static String inputNumber(Scanner sc) {
		
		String number;
		System.out.print("num: ");
		number = sc.nextLine();
		
		return number;
	}

	public static String inputCity(Scanner sc) {
		
		String city;
		System.out.print("City: ");
		city = sc.nextLine();
		
		return city;
	}

	public static int inputZipCode(Scanner sc) {
		
		int zipCode;
		System.out.print("ZIP Code: ");
		zipCode = sc.nextInt();
		
		return zipCode;
	}
	
	public static int inputTelephone(Scanner sc, int prefix) {
		int telephone = 0;
		
		System.out.print("Add your contact's telephone number: ");
		
		do {
		switch (prefix) {
		case 34: telephone = SpainTelephone.spanishTelephoneInput(sc);
			break;
	//	case 351: telephone = PortugalTelephone.portugalTelephoneInput(sc);
	//		break;
		}
		} while (telephone == 0);
		
		return telephone;
		
	}

}
