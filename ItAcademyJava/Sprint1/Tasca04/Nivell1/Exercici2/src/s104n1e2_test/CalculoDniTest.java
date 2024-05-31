package s104n1e2_test;

import s104n1e2.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculoDniTest {

	CalculoDni calculoDni1 = new CalculoDni();
	ArrayList<Integer> dniList = new ArrayList<Integer>();
	ArrayList<String> dniStringList = new ArrayList<String>();

	@BeforeEach
	public void setUp() {
		dniList = null;
		calculoDni1 = new CalculoDni();
	}

	@ParameterizedTest
	@ValueSource(ints = { 0000, 0000000000, 100000000, 9999, 99999999, 999999999, 65849235, 94586254, 25684975,
			246589512 })
	public void typeTest(int dniNum) {
		char dniChar = calculoDni1.calcularLletra(dniNum);
		Assertions.assertTrue(Character.class.isInstance(dniChar));
		Assertions.assertTrue(Integer.class.isInstance(dniNum));

	}

	@ParameterizedTest
	@ValueSource(ints = { 0000, 0000000000, 100000000, 9999, 99999999, 999999999, 65849235, 9458625, 25684975,
			246589512 })
	public void lengthTest(int dniNum) {
		char dniChar = calculoDni1.calcularLletra(dniNum);
		String dni = (String.valueOf(dniNum) + dniChar);
		// Provoca failure en los valores dniNum != 8
		if ((dniNum / 10000000 >= 1) && (dniNum / 100000000 < 1) && dniNum != 0) {
		Assertions.assertEquals(dni.length(), 9);
		} else {
			Assertions.assertNotEquals(dni.length(), 9);
		}

	}

	@ParameterizedTest
	@ValueSource(ints = { 0000, 0000000000, 100000000, 9999, 99999999, 999999999, 65849235, 94586254, 25684975,
			246589512 })
	public void dniCorrectTest(int dniNum) {
		char dniChar = calculoDni1.calcularLletra(dniNum);
		String dni = (String.valueOf(dniNum) + dniChar);
		Assertions.assertTrue(String.class.isInstance(dni));

	}

	@ParameterizedTest
	@ValueSource(ints = { 0000, 0000000000, 100000000, 9999, 99999999, 999999999, 65849235, 94586254, 25684975,
			246589512 })
	public void charTest(int dniNum) {
		char dniChar = calculoDni1.calcularLletra(dniNum);

		char lletraDni = '-';
		int moduloDni = dniNum % 23;
		String line = null;

		if ((dniNum / 10000000 >= 1) && (dniNum / 100000000 < 1)) {
			try {
				File conversor = new File("src\\s104n1e2_conversor\\conversor.txt");
				BufferedReader reader = new BufferedReader(new FileReader(conversor));
				for (int i = 0; i <= moduloDni; i++) {
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("Error en la lectura del document. ");
			}
			lletraDni = line.charAt(0);
		}
		Assertions.assertEquals(dniChar, lletraDni);
	}

}
