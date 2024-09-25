package factories;

import java.util.Scanner;


import implementations.ContactInput;
import implementations.SpainAddress;
import implementations.SpainTelephone;

public class SpainFactory implements ContactFactory {

	public Address addAddress(Scanner sc) {

		String street = ContactInput.inputStreet(sc);
		String number = ContactInput.inputNumber(sc);
		String city = ContactInput.inputCity(sc);
		String zipCode = "";
		do {
			zipCode = ContactInput.inputZipCode(sc);
			if (zipCode.length() != 5) {
				System.out.println("ZIP Code must have five digits. Please, enter it again. ");
			}
		} while (zipCode.length() != 5);

		return new SpainAddress(street, number, city, zipCode);
	}

	public Telephone addTelephone(Scanner sc, int prefix) {

		String telephone = ContactInput.inputTelephone(sc, prefix);
		return new SpainTelephone(telephone);
	}

}