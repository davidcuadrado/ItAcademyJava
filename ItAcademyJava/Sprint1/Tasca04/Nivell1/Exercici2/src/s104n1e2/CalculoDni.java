package s104n1e2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CalculoDni {

	public CalculoDni() {
		
	}
	
	public char calcularLletra(int dniNum) {
		char lletraDni = '-';
		int moduloDni = dniNum%23;
		String line = null;
		
		if ((dniNum/10000000 >= 1) && (dniNum/100000000 < 1)){
		try {
		File conversor = new File ("src\\s104n1e2_conversor\\conversor.txt");
		
		BufferedReader reader = new BufferedReader(new FileReader(conversor));
		
		for (int i = 0; i<=moduloDni; i++) {
			line = reader.readLine();
		}
		
		} catch (IOException e) {
			System.out.println("Error en la lectura del document. ");
		}
		lletraDni = line.charAt(0);
		} else {
			System.out.println("El número de DNI no és correcte. ");
		}
		
		return lletraDni;
	}
	
}
