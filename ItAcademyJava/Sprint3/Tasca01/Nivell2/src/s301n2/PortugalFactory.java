package s301n2;

import java.util.Scanner;

public class PortugalFactory implements ContactFactory {

	public Address addAddress(Scanner sc) {
		return new PortugalAddress();
	}

	public Telephone addTelephone(Scanner sc, int prefix) {
		return new PortugalTelephone();
	}

}
