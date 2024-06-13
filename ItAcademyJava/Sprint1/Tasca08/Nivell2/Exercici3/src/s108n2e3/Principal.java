package s108n2e3;

public class Principal {

	public static void main(String[] args) {

		float num1 = 5f;
		float num2 = 10f;
		char tipoOper = '+';

		Operar operar = (float numA, float numB, char operador) -> switch (tipoOper) {
		case '+' -> num1 + num2;
		case '-' -> num1 - num2;
		case '*' -> num1 * num2;
		case '/' -> num1 / num2;
		default -> throw new IllegalArgumentException("Unexpected value: " + tipoOper);

		};

		System.out.println("El teu resultat: " + num1 + tipoOper + num2 + " = " + operar.operacio(num1, num2, tipoOper));
	}
}
