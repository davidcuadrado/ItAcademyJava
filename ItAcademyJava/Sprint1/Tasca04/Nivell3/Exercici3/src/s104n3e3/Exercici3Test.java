package s104n3e3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Exercici3Test {

	@Test
	public void arrayEqualTest() {
		int[] array1 = {1, 2, 3};
		int[] array2 = {1, 2, 3};
		assertThat(array1).isEqualTo(array2);
	}

}
