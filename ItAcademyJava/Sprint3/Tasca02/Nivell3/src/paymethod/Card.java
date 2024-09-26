package paymethod;

public class Card implements PayMethod {

	private String ownerName;
	private int cardNumber;
	private String expirationDate;
	private int cvv;

	public Card() {

	}

	public Card(String ownerName, int cardNumber, String expirationDate, int cvv) {
		this.ownerName = ownerName;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
	}

	public void selectPayMethod(PayMethod card, int price) {
		System.out.println("Introduce your Credit Card data for " + price + "€ payment: ");

		Card cardPayment = new Card("Owen Pay", 651264923, "25/12", 888);

		System.out.println("Card payment is successful. ");
	}

}
