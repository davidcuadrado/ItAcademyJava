package s104n3e7;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

class Exercici7Test {

	@Test
	void optionalEmptyTest() {
		
		Optional<?> optional1 = Optional.empty();
		assertThat(optional1).isEmpty();
	}

}
