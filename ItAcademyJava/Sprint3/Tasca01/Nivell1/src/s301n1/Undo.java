package s301n1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Undo {
	
	private static Undo instance;
	private static ArrayList<String> commandList;
	
	private Undo() {
		commandList = new ArrayList<String>();
	}
	
	public static Undo getInstance() {
		if (Undo.instance == null) {
			new Undo();
			
		}
		
		return instance;	
	}
	
	
	public static void undoClear() {
		commandList.clear();
	}
	
	public static void undoOffset() {
		Undo.undoNote();
		System.out.println("Which element of the undo command list do you want to delete? ");
		System.out.print("Please, enter the possition of the commanda: ");
		try (Scanner sc = new Scanner(System.in)){
			int deleteCommandPoss = sc.nextInt();
			Undo.commandList.remove(deleteCommandPoss);
		} catch (InputMismatchException e) {
			System.out.println("Data type introduced doesn't match de requirements. ");
		} 
	}
	
	public static void undoNote() {
		System.out.println("Command list: ");
		System.out.println(commandList);
	}
	
	public static void undoRead() {
		// buffered reader for reading the file
	}
	
	public static void undoShowExpansion() {
		System.out.println("Undo expanded ");
		//Print commandList elements + file elements
		
	}
	
	public static void undoAppend() {
		// buffered writer for adding the elements from commandList to the file
	}
	
	public static void undoWrite() {
		// buffered writer for overwriting the file with the elements of the commandList
	}
	
	public static void undoStore() {
		// string builder of the commandList on a single line
		// buffered writer for saving the command as a single entry
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
