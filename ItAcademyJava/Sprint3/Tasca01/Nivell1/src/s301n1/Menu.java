package s301n1;

import java.util.Scanner;

public class Menu {

	public static void start() {

		System.out.println("Initializing... ");
		char option;

		do {
			option = getMenuOption();
			menuInit(option);
		} while (option != '0');

	}

	public static char getMenuOption() {
		char option = 'x';

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Select the desired action ");
			System.out.println("i. Add commands "); // añadir elemento a commandList mediante teclado
			System.out.println("d. Delete commands"); // usar undoOffset()
			System.out.println("n. Show commands in memory "); // use undoNote()
			System.out.println("r. Show commands in file"); // use undoRead()
			System.out.println("a. List commands in memory "); // usar undoAppend()
			System.out.println("w. File overwrite with last added commands"); // usar undoWrite()
			System.out.println("c. Clear commands in memory "); // usar undoClear()
			System.out.println("s. Store memory commands in file as a single line ");
			System.out.println("0. Exit the menu ");

			option = sc.nextLine().charAt(0);
		} catch (Exception e) {
			System.out.println("Data entry error. ");
		}

		return option;
	}

	public static void menuInit(char option) {

		System.out.println("Escull quina acció vols dur a terme: ");

		switch (option) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		}
	}

}
