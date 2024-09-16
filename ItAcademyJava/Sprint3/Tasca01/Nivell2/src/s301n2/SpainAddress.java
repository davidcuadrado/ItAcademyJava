package s301n2;

public class SpainAddress implements Address {

	private String street;
	private String number;
	private String city;
	private int zipCode;
	private final String country = "Spain";
	private final int prefix = 34;

	SpainAddress() {

	}

	SpainAddress(String street, String number, String city, int zipCode) {
		this.street = street;
		this.number = number;
		this.city = city;
		this.zipCode = zipCode;
	}

	public void setEntry() {

		System.out.println("Spanish address added. ");
	}

}
