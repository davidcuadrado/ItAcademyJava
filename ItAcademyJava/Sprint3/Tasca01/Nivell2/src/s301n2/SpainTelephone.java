package s301n2;

import java.util.Scanner;

public class SpainTelephone implements Telephone {
	
	private String telephone;
	private final int prefix = 34;
	
	SpainTelephone(){
	}
	
	SpainTelephone(String telephone){
		this.telephone = telephone;
	}
	
	public void setTelephone(Telephone telephone) {
		
		this.telephone = telephone.getTelephone();
		System.out.println("Spanish telephone added to your contact. ");
	}
	
	public static String spanishTelephoneInput(Scanner sc) {
		
		String telephone;
		
		System.out.print("Telephone: ");
		telephone = sc.nextLine();
		
		while (telephone.length() != 9) {
			System.out.println("Incorrect value for Spain telephones. Add a telephone number with 9 digits. \nTelephone:");
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