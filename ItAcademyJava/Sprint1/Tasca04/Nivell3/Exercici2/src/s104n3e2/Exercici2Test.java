package s104n3e2;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;


class Exercici2Test {

	@Test
	public void objectEqualsTest() {
		Valor obj1 = new Valor(5);
		Valor obj2 = new Valor(5);
		assertThat(obj1).isNotSameAs(obj2);
	}

}
