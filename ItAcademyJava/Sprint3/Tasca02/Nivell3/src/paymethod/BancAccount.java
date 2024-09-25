package paymethod;

public class BancAccount implements PayMethod {

	private String accountOwner;
	private int accountNumber;

	public BancAccount() {

	}

	public BancAccount(String accountOwner, int accountNumber) {
		this.accountOwner = accountOwner;
		this.accountNumber = accountNumber;
	}

	@Override
	public void selectPayMethod(PayMethod bancAccount, int price) {
		System.out.println("Introduce your Banc Account datadata for " + price + "€ payment: ");
		
		BancAccount accountPayment = new BancAccount("Owen Pay", 456558848);

		System.out.println("Banc account payment is successful. ");

	}

}
