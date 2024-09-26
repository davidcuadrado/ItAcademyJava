package s302n3;

import java.util.InputMismatchException;
import java.util.Scanner;

import paymethod.*;

public class PayGateway {

	private final int total;

	public PayGateway(int total) {
		this.total = total;
	}

	public void generate() {

		int payMethodOption = getMethodOption();

		switch (payMethodOption) {
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
			System.out.println("You have selected the Bank Account method. Redirecting... ");
			BankAccount bankAccount = new BankAccount();
			bankAccount.selectPayMethod(bankAccount, this.total);
		}

		}

	}

	public int getMethodOption() {

		int payMethodOption = 0;

		System.out.println("Select your preferred payment method: \n1. Credit Card \n2. PayPal \n3. Bank Account");

		try (Scanner sc = new Scanner(System.in)) {
			do {
				payMethodOption = sc.nextInt();
			} while (!(payMethodOption >= 1 && payMethodOption <= 3));
		} catch (InputMismatchException e) {
			System.out.println("Input data mismatch. Please try again. ");
		}

		return payMethodOption;
	}

}
