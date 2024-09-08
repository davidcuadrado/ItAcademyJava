package s301n2;

public class SpainFactory implements ContactFactory {
	
	public Address addAddress() {
		return new SpainAddress();
	}
	public Telephone addTelephone() {
		return new SpainTelephone();
	}
	
	
}
