package s301n2;

import java.util.Scanner;

public class SpainTelephone implements Telephone {

	public void setEntry(Scanner sc) {
		String address;

		System.out.print("Enter the address: ");
		do {
			address = sc.nextLine();
		} while (address.isEmpty());

		System.out.println("Spanish telephone added. ");
	}

}
