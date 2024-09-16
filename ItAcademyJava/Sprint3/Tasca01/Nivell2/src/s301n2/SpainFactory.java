package s301n2;

import java.util.Scanner;

public class SpainFactory implements ContactFactory {

	public Address addAddress(Scanner sc) {
		
		String street = CountryMethod.inputStreet(sc);
		String number = CountryMethod.inputNumber(sc);
		String city = CountryMethod.inputCity(sc);
		int zipCode = CountryMethod.inputZipCode(sc);
		
		return new SpainAddress(street, number, city, zipCode);
	}

	public Telephone addTelephone(Scanner sc, int prefix) {
		
		int telephone = CountryMethod.inputTelephone(sc, prefix);
		return new SpainTelephone(telephone);
	}

}
