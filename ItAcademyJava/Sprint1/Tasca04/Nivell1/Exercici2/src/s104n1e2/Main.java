package s104n1e2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce los dígitos del DNI a calcular");
		int dniNum = sc.nextInt();
		
		
		CalculoDni calculoDni1 = new CalculoDni();
		char dniChar = calculoDni1.calcularLletra(dniNum);
		
		if ((dniNum / 10000000 >= 1) && (dniNum / 100000000 < 1)) {
		System.out.println("El DNI es: "+(dniNum)+""+""+(dniChar)+". ");
		}
		sc.close();

	}

}
