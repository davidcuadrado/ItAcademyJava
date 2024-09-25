package implementations;

import java.util.Scanner;

import factories.Telephone;

public class PortugalTelephone implements Telephone {

	private String telephone;
	private final int prefix = 351;

	PortugalTelephone() {
	}

	public PortugalTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setTelephone(Telephone telephone) {

		this.telephone = telephone.getTelephone();
		System.out.println("Portuguesse telephone added to your contact. ");
	}

	public static String portugalTelephoneInput(Scanner sc) {

		String telephone;

		System.out.print("Telephone: ");
		telephone = sc.nextLine();

		while (telephone.length() != 9) {
			System.out.println(
					"Incorrect value for Portugal telephones. Add a telephone number with 9 digits. \nTelephone:");
			sc.nextLine();
			telephone = sc.nextLine();
		}
		new PortugalTelephone(telephone);
		return telephone;
	}

	public String getTelephone() {
		return "+" + prefix + " " + telephone;
	}

	public String toString() {
		return this.telephone;
	}

}