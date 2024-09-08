package s301n2;

import java.util.Scanner;

public class SpainAddress implements Address {
	
	private String street;
	private int number;
	private String city;
	private int zipCode;
	private final String country = "Spain";
	

	public void setEntry(Scanner sc) {
		String address;
		
		System.out.print("Enter the address: ");
		do {
			address = sc.nextLine();
		} while (address.isEmpty());
		
		System.out.println("Spanish address added. ");
	}

}
