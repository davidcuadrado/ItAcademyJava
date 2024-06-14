package s108n2e3;

public class Principal {

	public static void main(String[] args) {

		float num1 = 3.33f;
		float num2 = 6.66f;

		Operar sumar = () ->  num1 + num2;
		Operar restar = () -> num1 - num2;
		Operar multiplicar = () -> num1 * num2;
		Operar dividir = () -> num1 / num2;
		List<Operar> operacionsPosibles = List.of(sumar, restar, multiplicar, dividir);
		
		operacionsPosibles.forEach(n -> System.out.println("Resultat: " + n.operacio()));		
	}
}
