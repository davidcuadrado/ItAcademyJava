package s104n3e1_test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Exercici1Test {

	@Test
	public void equalTest() {
		int num1 = (int) 8;
		int num2 = (int) 8;
		assertThat(num1).isEqualTo(num2);
	}
	
	@Test
	public void notEqualTest() {
		int num1 = (int) 5;
		int num2 = (int) 8;
		assertThat(num1).isNotEqualTo(num2);
	}

}
