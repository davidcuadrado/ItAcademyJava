package s301n2;

import java.util.Scanner;

public class PortugalTelephone implements Telephone {

	private String telephone;
	private final int prefix = 351;

	public void setTelephone(Telephone telephone) {
		// codigo introducción teléfono
		System.out.println("Portuguesse telephone added. ");
	}

	public static String portugalTelephoneInput(Scanner sc) {

		String telephone;

		System.out.print("Telephone: ");
		telephone = sc.nextLine();

		while (telephone.length() != 9) {
			System.out.println(
					"Incorrect value for Spain telephones. Add a telephone number with 9 digits. \nTelephone:");
			sc.nextLine();
			telephone = sc.nextLine();
		}
		new SpainTelephone(telephone);
		return telephone;
	}

	public String getTelephone() {
		return "+" + prefix + " " + telephone;
	}

}