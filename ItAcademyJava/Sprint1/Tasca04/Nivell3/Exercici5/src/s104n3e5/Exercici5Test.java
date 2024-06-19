package s104n3e5;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashMap;

import org.junit.jupiter.api.Test;


class Exercici5Test {
	
	HashMap<Integer, String> map1 = new HashMap<Integer, String>();
	
	
	@Test
	void mapContainsKeyTest() {
		map1.put(1, "Barcelona");
		map1.put(2, "Madrid");
		
		assertThat(map1).containsKey(1);
	}

}
