package paymethod;

public class BankAccount implements PayMethod {

	private String accountOwner;
	private int accountNumber;

	public BankAccount() {

	}

	public BankAccount(String accountOwner, int accountNumber) {
		this.accountOwner = accountOwner;
		this.accountNumber = accountNumber;
	}

	@Override
	public void selectPayMethod(PayMethod bancAccount, int price) {
		System.out.println("Introduce your Bank Account data for " + price + "€ payment: ");

		BankAccount accountPayment = new BankAccount("Owen Pay", 456558848);

		System.out.println("Banc account payment is successful. ");

	}

}
