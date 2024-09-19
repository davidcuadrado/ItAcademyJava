package s301n2;

import java.util.Scanner;

public class ContactInput {
	
	public static String inputName(Scanner sc) {

		String name;
		System.out.print("Name: ");
		name = sc.nextLine();

		return name;
	}

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

	public static String inputZipCode(Scanner sc) {

		String zipCode;
		System.out.print("ZIP Code: ");
		zipCode = sc.nextLine();

		return zipCode;
	}

	public static String inputTelephone(Scanner sc, int prefix) {
		String telephone = "0";

		do {
			switch (prefix) {
			case 34:
				telephone = SpainTelephone.spanishTelephoneInput(sc);
				break;
			case 351: 
				telephone = PortugalTelephone.portugalTelephoneInput(sc);
				break;
			}
		} while (telephone == "0");

		return telephone;

	}

}