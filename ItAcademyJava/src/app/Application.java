package app;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		

		try (Scanner sc = new Scanner(System.in)) {
			Menu.runMenu(sc);

		}catch (Exception e) {
			System.out.println("Data entry error. ");
		}

	}

}
