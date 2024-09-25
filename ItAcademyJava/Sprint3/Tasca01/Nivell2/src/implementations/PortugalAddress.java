package implementations;

import factories.Address;

public class PortugalAddress implements Address {

	private String street;
	private String number;
	private String city;
	private String zipCode;
	private final String country;

	PortugalAddress() {
		this.country = "Portugal";

	}

	public PortugalAddress(String street, String number, String city, String zipCode) {
		this.street = street;
		this.number = number;
		this.city = city;
		this.zipCode = zipCode;
		this.country = "Portugal";
	}

	public void setAddress(Address adress) {

		System.out.println("Portugal address added to your contact. ");
	}

	public String getAddress() {
		return street + ", " + number + ", " + zipCode + city.toUpperCase() + " (" + country + ") ";
	}

}