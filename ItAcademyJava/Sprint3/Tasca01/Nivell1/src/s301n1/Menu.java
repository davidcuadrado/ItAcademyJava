package s301n1;

import java.util.Scanner;

public class Menu {

	public static void start(Scanner sc) {

		System.out.println("Initializing... ");
		char option = 'X';
		Command.setInstance();
		Undo.setInstance();

		do {
			String inputCommand = Command.commandInput(sc);
			Undo.undoInput(inputCommand);
			
			switch (inputCommand) {
			case "terminate" -> option = '9';
			case "undo" -> { 
				option = Undo.getUndoOption(sc);
				Undo.undoInit(option, sc);
				}
			
			default -> System.out.println("** Command " + inputCommand + " execution **");
			
			}

		} while (option != '9');
		menuClose();

	}

	public static void menuClose() {
		System.out.println("Terminating program execution execution... ");
	}

}