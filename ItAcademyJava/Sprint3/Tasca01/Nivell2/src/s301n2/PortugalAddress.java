package s301n2;

public class PortugalAddress implements Address {

	private String street;
	private String number;
	private String city;
	private int zipCode;
	private final String country = "Spain";
	private final int prefix = 34;

	PortugalAddress() {

	}

	PortugalAddress(String street, String number, String city, int zipCode) {
		this.street = street;
		this.number = number;
		this.city = city;
		this.zipCode = zipCode;
	}

	public void setEntry() {
		// codigo introducción dirección
		System.out.println("Portuguesse address added. ");
	}

}
