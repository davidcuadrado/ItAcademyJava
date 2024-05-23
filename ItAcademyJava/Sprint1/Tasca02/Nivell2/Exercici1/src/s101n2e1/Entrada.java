package s101n2e1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

	public static byte llegirByte(String missatge) {
		Scanner sc = new Scanner(System.in);
		byte inputByte = 0;
		boolean esByte = false;

		do {
			System.out.println(missatge);
			try {
				inputByte = sc.nextByte();
				if (Byte.class.isInstance(inputByte)) {
					esByte = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Error de format.");
			} finally {
				sc.nextLine();
			}

		} while (!esByte);

		return inputByte;
	}

	public static int llegirInt(String missatge) {
		Scanner sc = new Scanner(System.in);
		int inputInt = 0;
		boolean esInt = false;

		do {
			System.out.println(missatge);
			try {
				inputInt = sc.nextInt();
				if (Integer.class.isInstance(inputInt)) {
					esInt = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Error de format. ");
			} finally {
				sc.nextLine();
			}
		} while (!esInt);
		return inputInt;
	}

	public static float llegirFloat(String missatge) {
		Scanner sc = new Scanner(System.in);
		float inputFloat = 0f;
		boolean esFloat = false;

		do {
			System.out.println(missatge);
			try {
				inputFloat = sc.nextFloat();
				if (Float.class.isInstance(inputFloat)) {
					esFloat = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Error de format.");
			} finally {
				sc.nextLine();
			}

		} while (!esFloat);

		return inputFloat;
	}

	public static double llegirDouble(String missatge) {
		Scanner sc = new Scanner(System.in);
		double inputDouble = 0d;
		boolean esDouble = false;

		do {
			System.out.println(missatge);
			try {
				inputDouble = sc.nextDouble();
				if (Double.class.isInstance(inputDouble)) {
					esDouble = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Error de format.");
			} finally {
				sc.nextLine();
			}

		} while (!esDouble);

		return inputDouble;
	}

	public static String llegirString(String missatge) {
		Scanner sc = new Scanner(System.in);
		String inputString = "";

		do {
			System.out.println(missatge);
			try {
				inputString = sc.nextLine();
			} catch (Exception e) {
				System.out.println("Error en la introducció de dades.");
			}

		} while (!(inputString instanceof String));

		return inputString;
	}

	public static char llegirChar(String missatge) {
		Scanner sc = new Scanner(System.in);
		char inputChar = 0;

		do {
			System.out.println(missatge);
			try {
				inputChar = sc.nextLine().charAt(0);
			} catch (Exception e) {
				System.out.println("Error en la introducció de dades.");
			}

		} while (!(Character.class.isInstance(inputChar)));

		return inputChar;
	}

	public static boolean llegirSiNo(String missatge) {
		Scanner sc = new Scanner(System.in);
		char inputString = 0;
		boolean inputSiNo = false;

		do {
			System.out.println(missatge);
			try {
				inputString = sc.nextLine().charAt(0);
			} catch (Exception e) {
				System.out.println("Error en la introducció de dades.");
			}
			if (inputString == 's') {
				inputSiNo = true;
			}
			if (inputString == 'n') {
				inputSiNo = false;
			}

		} while (!(inputString == 's' || inputString == 'n'));

		return inputSiNo;
	}

}
