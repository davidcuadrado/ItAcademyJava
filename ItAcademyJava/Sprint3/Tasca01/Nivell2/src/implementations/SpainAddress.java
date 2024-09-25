package implementations;

import factories.Address;

public class SpainAddress implements Address {

	private String street;
	private String number;
	private String city;
	private String zipCode;
	private final String country;

	SpainAddress() {
		this.country = "Spain";

	}

	public SpainAddress(String street, String number, String city, String zipCode) {
		this.street = street;
		this.number = number;
		this.city = city;
		this.zipCode = zipCode;
		this.country = "Spain";
	}

	public void setAddress(Address address) {

		System.out.println("Spanish address added to your contact. ");

	}

	public String getAddress() {
		return street + ", " + number + ", " + zipCode + " " + city.toUpperCase() + " (" + country + ") ";
	}

}