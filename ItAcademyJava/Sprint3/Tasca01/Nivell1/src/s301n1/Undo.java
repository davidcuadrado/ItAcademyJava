package s301n1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Undo {

	private static Undo instance;
	private static ArrayList<String> commandList;
	private static String directory = "../Undo.txt";
	private static File undoFile = new File(Undo.directory);

	private Undo() {
		commandList = new ArrayList<String>();
	}

	public static Undo getInstance() {
		if (Undo.instance == null) {
			new Undo();

		}

		return instance;
	}

	public static void undoAdd(char option) {
		int i = 0;
		boolean match = false;

		String input = String.valueOf(option);

		while (i < commandList.size() & match == false) {
			if (commandList.get(i).equals(input)) {
				match = true;
			} else {
				i++;
			}

		}
		if (match == true) {
			commandList.remove(i);
		}
		commandList.add(input);
	}

	public static void undoInput(Scanner sc) {
		int i = 0;
		boolean match = false;

		System.out.print("Type input: ");
		String input = sc.nextLine();

		while (i < commandList.size() & match == false) {
			if (commandList.get(i).equals(input)) {
				match = true;
			} else {
				i++;
			}

		}
		if (match == true) {
			commandList.remove(i);
		}
		commandList.add(input);

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
			try {
				int deleteCommandPoss = sc.nextInt();
				System.out.println("The command \'" + commandList.get(deleteCommandPoss) + "\' has been deleted. \n");
				Undo.commandList.remove(deleteCommandPoss);
			} catch (InputMismatchException e) {
				System.out.println("Data type input mismatch. \n");
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
		// Print commandList elements + file elements

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
				"This action will overwrite a file. All previous listed commands will be erase. Press \'0\' to confirm. ");

		char confirm = sc.nextLine().charAt(0);
		if (confirm != '0') {
			System.out.println("Overwrite aborted. Returning to the menu. \n");
		}

		return confirm;
	}

	public static void undoStore() {
		// string builder of the commandList on a single line
		// buffered writer for saving the command as a single entry
	}

}
