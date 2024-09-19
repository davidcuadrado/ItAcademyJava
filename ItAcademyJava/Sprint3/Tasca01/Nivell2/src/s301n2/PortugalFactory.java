package s301n2;

import java.util.Scanner;

public class PortugalFactory implements ContactFactory {

	public Address addAddress(Scanner sc) {
		
		String street = ContactInput.inputStreet(sc);
		String number = ContactInput.inputNumber(sc);
		String city = ContactInput.inputCity(sc);
		String zipCode = ContactInput.inputZipCode(sc);
		
		return new PortugalAddress();
	}

	public Telephone addTelephone(Scanner sc, int prefix) {

		String telephone = ContactInput.inputTelephone(sc, prefix);
		
		return new PortugalTelephone();
	}

}