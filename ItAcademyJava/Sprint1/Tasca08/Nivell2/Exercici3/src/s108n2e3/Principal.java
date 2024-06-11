package s108n2e3;


/*
import java.util.InputMismatchException;
import java.util.Scanner;
*/

public class Principal {

	public static void main(String[] args) {

		Operar operar = (num1, num2, operador) -> switch (operador) {
		case '+' -> num1 + num2;
		case '-' -> num1 - num2;
		case '*' -> num1 * num2;
		case '/' -> num1 / num2;
		default -> throw new IllegalArgumentException("Unexpected value: " + operador);
		};
		
		System.out.println(operar.operacio(5, 25, '+'));
		System.out.println(operar.operacio(5, 25, '-'));
		System.out.println(operar.operacio(5, 25, '*'));
		System.out.println(operar.operacio(5, 0, '/'));

		// printOperar(operar);

	}
/*
	public static char demanarOperador() {
		char operador = 'O';

		try (Scanner sc = new Scanner(System.in)) {

			do {
				System.out.println("Introdueix el símbol de l'operació que vols dur a terme: +, -, * o / ");
				operador = sc.nextLine().charAt(0);

			} while (!(operador == '+' || operador == '-' || operador == '*' || operador == '/'));
			return operador;

		} catch (Exception e) {
			System.out.println("Error en la introducció de dades. ");
		}
		return operador;

	}

	public static void printOperar(Operar operar) {

		float numA = demanarFloat(); //8.36f;
		float numB = demanarFloat(); //10.54f;
		char operadorMath = demanarOperador();
		System.out.println(operar.operacio(numA, numB, operadorMath));

	}

	public static float demanarFloat() {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Introdueix un float: ");
			float numFloat =  sc.nextFloat();
			return  numFloat;
		} catch (InputMismatchException e) {
			System.out.println("Error en la introducció de dades. ");
		}

		return 0f;
	}
*/
}
