package s301n2;

public class SpainAddress implements Address {

	private String street;
	private String number;
	private String city;
	private String zipCode;
	private final String country;
	

	SpainAddress() {
		this.country = "Spain";

	}

	SpainAddress(String street, String number, String city, String zipCode) {
		this.street = street;
		this.number = number;
		this.city = city;
		this.zipCode = zipCode;
		this.country = "Spain";
	}

	
	public void setAddress(Address address) {
		
		this.street = street;
		this.number = number;
		this.city = city;
		this.zipCode = zipCode;
		
		System.out.println("Spanish address added to your contact. ");
	}
	
	public String getAddress() {
		return street + ", " + number + ", " + zipCode + city.toUpperCase() + " (" + country + ") ";
	}

}