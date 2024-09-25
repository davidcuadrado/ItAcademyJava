package factories;

import java.util.Scanner;

import implementations.ContactInput;
import implementations.PortugalAddress;
import implementations.PortugalTelephone;

public class PortugalFactory implements ContactFactory {

	public Address addAddress(Scanner sc) {

		String street = ContactInput.inputStreet(sc);
		String number = ContactInput.inputNumber(sc);
		String city = ContactInput.inputCity(sc);
		String zipCode = "";
		do {
			zipCode = ContactInput.inputZipCode(sc);
			if (zipCode.length() != 8) {
				System.out.println("ZIP Code must have eight digits. Please, enter it again. ");
			}
		} while (zipCode.length() != 8);

		return new PortugalAddress(street, number, city, zipCode);
	}

	public Telephone addTelephone(Scanner sc, int prefix) {

		String telephone = ContactInput.inputTelephone(sc, prefix);
		return new PortugalTelephone(telephone);
	}

}