package s301n1;

import java.util.ArrayList;
import java.util.Scanner;

public class Command {

	private static Command instance;
	public static ArrayList<String> allowedCommand;

	public static Command setInstance() {
		if (Command.instance == null) {
			instance = new Command();
			allowedCommand = setAllowedCommand();
		}
		return instance;
	}

	public static ArrayList<String> setAllowedCommand() {
		ArrayList<String> allowedCommand = new ArrayList<String>();
		allowedCommand.add("undo");
		allowedCommand.add("start");
		allowedCommand.add("check");
		allowedCommand.add("move");
		allowedCommand.add("terminate");

		return allowedCommand;
	}

	public static String commandInput(Scanner sc) {

		String inputCommand;
		boolean commandExist = false;
		int i;

		do {
			System.out.print("Command Input: ");
			inputCommand = sc.nextLine();
			i = 0;

			while (i < allowedCommand.size() && !commandExist) {
				if (allowedCommand.get(i).equals(inputCommand)) {
					commandExist = true;
				} else {
					i++;
				}

			}

		} while (!commandExist);

		return inputCommand;
	}

}
