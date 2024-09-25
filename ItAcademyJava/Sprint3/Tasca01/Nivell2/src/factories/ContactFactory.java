package factories;

import java.util.Scanner;

public interface ContactFactory {
	

	Address addAddress(Scanner sc);

	Telephone addTelephone(Scanner sc, int prefix);

}