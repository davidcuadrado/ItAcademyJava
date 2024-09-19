package s301n2;

public class Contact {

	private String name;
	private Address address;
	private Telephone telephone;

	public Contact(String name) {
		this.name = name;
	}

	public Contact(String name, Address address, Telephone telephone) {
		this.name = name;
		this.address = address;
		this.telephone = telephone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Telephone getTelephone() {
		return telephone;
	}

	public void setTelephone(Telephone telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", address=" + address.getAddress() + ", telephone=" + telephone.getTelephone() + "]";
	}

}
