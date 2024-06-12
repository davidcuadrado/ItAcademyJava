package s108n2e3;


/*
import java.util.InputMismatchException;
import java.util.Scanner;
*/

public class Principal {

	public static void main(String[] args) {

		float num1 = 5f;
		float num2 = 10f;
		char tipoOper = demanarOperador();

		Operar operar = (float numA, float numB, char operador) -> switch (tipoOper) {
		case '+' -> num1 + num2;
		case '-' -> num1 - num2;
		case '*' -> num1 * num2;
		case '/' -> num1 / num2;
		default -> throw new IllegalArgumentException("Unexpected value: " + tipoOper);

		};

		System.out.println("El teu resultat: " + num1 + tipoOper + num2 + " = " + operar.operacio(num1, num2, tipoOper));

	}

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
}
