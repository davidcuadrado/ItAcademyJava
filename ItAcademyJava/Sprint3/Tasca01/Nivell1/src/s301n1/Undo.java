package s301n1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Undo {

	private static Undo instance;
	private static ArrayList<String> commandList;
	private final static String directory = "../Undo.txt";
	private final static File undoFile = new File(Undo.directory);

	private Undo() {

		commandList = new ArrayList<String>();
	}

	public static Undo setInstance() {
		if (Undo.instance == null) {
			instance = new Undo();
		}
		return instance;
	}

	public static char getUndoOption(Scanner sc) {
		char option = 'X';

		System.out.println("Select your undo command action: ");
		System.out.println("d. Delete commands"); // use undoOffset()
		System.out.println("n. Show commands in memory "); // use undoNote()
		System.out.println("r. Show commands in file"); // use undoRead()
		System.out.println("a. List commands in memory "); // use undoAppend()
		System.out.println("w. File overwrite with last added commands"); // use undoWrite()
		System.out.println("c. Clear commands in memory "); // use undoClear()
		System.out.println("0. Exit undo option menu ");

		String input = sc.nextLine();

		if (input.length() != 1) {
			System.out.println("Command input error. \n");
		} else {
			option = input.charAt(0);
			if (option == 'd' || option == 'n' || option == 'r' || option == 'a' || option == 'w' || option == 'c'
					|| option == '0') {
				undoAdd(option);
				return option;
			} else {
				System.out.println("Input doesn't match an existing undo action. \n");

			}
		}

		return option;
	}

	public static void undoInit(char option, Scanner sc) {

		switch (option) {
		case 'd' -> Undo.undoOffset(sc);
		case 'n' -> Undo.undoNote();
		case 'r' -> Undo.undoRead();
		case 'a' -> Undo.undoAppend();
		case 'w' -> Undo.undoWrite(sc);
		case 'c' -> Undo.undoClear();
		case '0' -> System.out.println("Undo action cancelled. \n");
		}
		
	}

	
	public static void undoAdd(char option) {
		int i = 0;
		boolean match = false;

		String input = String.valueOf(option);

		while (i < commandList.size() & !match) {
			if (Undo.commandList.get(i).equals("undo -" + input)) {
				match = true;
			} else {
				i++;
			}

		}
		if (match) {
			commandList.remove(i);
		}
		commandList.add("undo -" + input);
	}

	public static void undoInput(String inputCommand) {
		int i = 0;
		boolean match = false;

		while (i < commandList.size() & !match) {
			if (commandList.get(i).equals(inputCommand)) {
				match = true;
			} else {
				i++;
			}
		}
		if (match) {
			commandList.remove(i);
			commandList.add(inputCommand);
		} else {
			if (!inputCommand.equals("undo"))
				commandList.add(inputCommand);
		}

		System.out.println("\n");
	}

	public static void undoClear() {
		commandList.clear();
		System.out.println("Command list has been reseted. \n");
	}

	public static void undoOffset(Scanner sc) {
		Undo.undoNote();
		if (commandList.size() == 0) {
			System.out.println("Command list for this session is empty. \n ");
		} else {
			System.out.println("Which element of the command list do you want to delete? ");
			System.out.print("Please, enter the command possition: ");

			int deleteCommandPoss = sc.nextInt();
			if (!(deleteCommandPoss >= commandList.size())) {
				System.out.println("The command '" + commandList.get(deleteCommandPoss) + "' has been deleted. \n");
				Undo.commandList.remove(deleteCommandPoss);
			} else {
				System.out.println("Null command possition. ");
			}

			sc.nextLine();
		}
	}

	public static void undoNote() {
		System.out.println("Command list: " + commandList + " \n");
	}

	public static void undoRead() {
		if (undoFile.isFile() && undoFile.getName().endsWith(".txt")) {
			try (BufferedReader br = new BufferedReader(new FileReader(directory))) {
				String lineaPrint = br.readLine();
				do {
					System.out.println(lineaPrint);
				} while ((lineaPrint = br.readLine()) != null);

			} catch (IOException e) {
				System.out.println("File not found. Check file directory. ");
			}
		} else {
			System.out.println("Unexpected format directory. ");
		}
	}

	public static void undoShowExpansion() {
		System.out.println("Expanded command list: ");
		undoRead();
		System.out.println();

	}

	public static void undoAppend() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(directory, true))) {
			for (String commandAdd : commandList) {
				bw.write(commandAdd + "\n");

			}
		} catch (IOException e) {
			System.out.println("File not found. Check file directory. ");
		}
	}

	public static void undoWrite(Scanner sc) {
		char confirm = overwriteCheck(sc);
		if (confirm == '0') {
			try (BufferedWriter bf = new BufferedWriter(new FileWriter(directory))) {
				for (String commandAdd : commandList) {
					bf.write(commandAdd + "\n");

				}
			} catch (IOException e) {
				System.out.println("File not found. Check file directory. ");
			}
		}
	}

	public static char overwriteCheck(Scanner sc) {
		System.out.println(
				"This action will overwrite a file. All previous listed commands will be erase. Press '0' to confirm. ");

		char confirm = sc.nextLine().charAt(0);
		if (confirm != '0') {
			System.out.println("Overwrite aborted. Returning to the menu. \n");
		}

		return confirm;
	}

}