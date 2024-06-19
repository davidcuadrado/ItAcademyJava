package s104n1e2_test;

import s104n1e2.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculoDniTest {

	CalculoDni calculoDni1 = new CalculoDni();

	private static Stream<Arguments> dniPredefinits() {
		return Stream.of(Arguments.of(34586498, 'H'), Arguments.of(45926775, 'F'), Arguments.of(34865971, 'H'),
				Arguments.of(61248537, 'C'), Arguments.of(35694528, 'T'), Arguments.of(84532699, 'V'),
				Arguments.of(75426485, 'D'), Arguments.of(26458521, 'B'), Arguments.of(32654851, 'A'),
				Arguments.of(75426589, 'K'));
	}

	@BeforeEach
	public void setUp() {
		calculoDni1 = new CalculoDni();
	}

	@ParameterizedTest
	@MethodSource("dniPredefinits")
	public void typeTest(int dniNum, char dniChar) {
		char lletraEsperada = calculoDni1.calcularLletra(dniNum);
		Assertions.assertTrue(Character.class.isInstance(dniChar));
		Assertions.assertTrue(Character.class.isInstance(lletraEsperada));
		Assertions.assertTrue(Integer.class.isInstance(dniNum));

	}

	@ParameterizedTest
	@MethodSource("dniPredefinits")
	public void lengthTest(int dniNum, char dniChar) {
		char lletraEsperada = calculoDni1.calcularLletra(dniNum);
		String dni = (String.valueOf(dniNum) + lletraEsperada);
		// Provoca failure en los valores dniNum != 8
		if ((dniNum / 10000000 >= 1) && (dniNum / 100000000 < 1) && dniNum != 0) {
			Assertions.assertEquals(dni.length(), 9);
		} else {
			Assertions.assertEquals(dni.length(), 9);
		}

	}

	@ParameterizedTest
	@MethodSource("dniPredefinits")
	public void dniToStringTest(int dniNum, char dniChar) {
		char lletraEsperada = calculoDni1.calcularLletra(dniNum);
		String dni = (String.valueOf(dniNum) + lletraEsperada);
		Assertions.assertTrue(String.class.isInstance(dni));

	}

	@ParameterizedTest
	@MethodSource("dniPredefinits")
	public void charTest(int dniNum, char dniChar) {
		char lletraEsperada = calculoDni1.calcularLletra(dniNum);
		Assertions.assertEquals(dniChar, lletraEsperada);
	}

}
