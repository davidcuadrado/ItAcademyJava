package s301n2;

import java.util.Scanner;

public class SpainTelephone implements Telephone {
	
	private int telephone;
	
	SpainTelephone(){
	}
	
	SpainTelephone(int telephone){
		this.telephone = telephone;
	}
	
	public void setEntry() {
		
		System.out.println("Spanish telephone added. ");
	}
	
	public static int spanishTelephoneInput(Scanner sc) {
		
		int telephone = 0;
		
		System.out.print("Telephone: ");
		telephone = sc.nextInt();
		
		while (telephone > 999999999 || telephone < 100000000) {
			System.out.println("Incorrect value for Spain telephones. Add a telephone number with 9 digits. \nTelephone:");
			telephone = sc.nextInt();
		}
		
		return telephone;
	}

}
