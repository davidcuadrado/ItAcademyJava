package s104n3e4;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Exercici4Test {

	@Test
	public void listContainsTest() {
		ArrayList<Object> llista = new ArrayList<Object>();
		String str1 = "String for testing";
		String str2 = "Second string for testing";
		int num1 = 5;
		byte num2 = 12;
		llista.add(str1);
		llista.add(num1);
		llista.add(num2);
		assertThat(llista).contains(str1, num1, num2);
		assertThat(llista).containsOnlyOnce(str1);
		assertThat(llista).doesNotContain(str2);

}
	
}
