package implementations;

import java.util.ArrayList;

public class ContactList {
	
	private static ContactList instance;
	public static ArrayList<Contact> contactList;
	
	private ContactList() {

		contactList = new ArrayList<Contact>();
	}

	public static ContactList setInstance() {
		if (ContactList.instance == null) {
			instance = new ContactList();
		}
		return instance;
	}
	
	


}
