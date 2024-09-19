package s301n2;

import java.util.Scanner;

public class Manager {

	private Address address;
	private Telephone telephone;

	public Manager(Scanner sc, ContactFactory contact, int prefix) {
		this.address = contact.addAddress(sc);
		this.telephone = contact.addTelephone(sc, prefix);
	}
	
	public static Manager configureManager(Scanner sc, int prefix) {
		Manager manager;
		ContactFactory contact = null;
		
		switch (prefix) {
		case 34 -> contact = new SpainFactory();
		case 351 -> contact = new PortugalFactory();
		}

		manager = new Manager(sc, contact, prefix);
		return manager;
	}

	public void setContactEntry(String name) {
		
		address.setAddress(this.address);
		telephone.setTelephone(this.telephone);
		
		Contact newContact = new Contact(name);
		newContact.setAddress(address);
		newContact.setTelephone(telephone);
		newContact.toString();
		
		

	}

	

}
