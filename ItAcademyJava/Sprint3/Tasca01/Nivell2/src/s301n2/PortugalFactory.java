package s301n2;

public class PortugalFactory implements ContactFactory {
	
	public Address addAddress() {
		return new PortugalAddress();
	}
	public Telephone addTelephone() {
		return new PortugalTelephone();
	}
	

}
