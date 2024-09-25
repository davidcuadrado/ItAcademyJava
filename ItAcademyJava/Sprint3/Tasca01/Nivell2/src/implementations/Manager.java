package implementations;

import java.util.Scanner;

import factories.Address;
import factories.ContactFactory;
import factories.PortugalFactory;
import factories.SpainFactory;
import factories.Telephone;

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
		
		Contact addContact = new Contact(name);
		addContact.setAddress(address);
		addContact.setTelephone(telephone);
		addContact.toString();
		
		ContactList.setInstance();
		ContactList.contactList.add(addContact);
		
		

	}

	

}
