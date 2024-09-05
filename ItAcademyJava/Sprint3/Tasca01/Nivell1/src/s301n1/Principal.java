package s301n1;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Menu.start(sc);
		} catch (Exception e) {
			System.out.println("Data entry error. ");
		}

	}
}