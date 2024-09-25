package s302n3;

import paymethod.*;

public class PayGateway {
	
	private final int total;
	
	public PayGateway(int total) {
		this.total = total;
	}

	public void generate() {

		System.out.println("Select your preferred payment method: ");
		int random = (int) (Math.random() * 3 + 1);
		switch (random) {
		case 1 -> {
			System.out.println("You have selected the Card method. Redirecting... ");
			Card card = new Card();
			card.selectPayMethod(card, this.total);
		}

		case 2 -> {
			System.out.println("You have selected the PayPal method. Redirecting... ");
			PayPal paypal = new PayPal();
			paypal.selectPayMethod(paypal, this.total);
		}

		case 3 -> {
			System.out.println("You have selected the Banc Account method. Redirecting... ");
			BancAccount bancAccount = new BancAccount();
			bancAccount.selectPayMethod(bancAccount, this.total);
		}

		}

	}

}
