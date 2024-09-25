package paymethod;

public class PayPal implements PayMethod {

	private String userName;

	public PayPal() {

	}

	public PayPal(String userName) {
		this.userName = userName;
	}

	@Override
	public void selectPayMethod(PayMethod payPal, int price) {
		System.out.println("Introduce your PayPal data for " + price + "€ payment: ");
		
		PayPal payPalPayment = new PayPal("payments@thepayer.com");

		System.out.println("PayPal payment is successful. ");

	}

}
