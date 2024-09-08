package s301n2;

import java.util.Scanner;

public class Manager {
	
	private Address address;
	private Telephone telephone;
	
	public Manager(ContactFactory contact) {
		this.address = contact.addAddress();
		this.telephone = contact.addTelephone();
	}
	
	public void setContactEntry(Scanner sc) {
		address.setEntry(sc);
		telephone.setEntry(sc);
		
	}
	
	public static Manager configureManager(int prefix) {
		Manager manager;
		ContactFactory contact = null;
		
		switch (prefix) {
		case 34 -> contact = new SpainFactory();
		case 351 -> contact = new PortugalFactory();
		default -> System.out.println("Unknown prefix added");
		}
		
		manager = new Manager(contact);
		return manager;
	}
	

}
