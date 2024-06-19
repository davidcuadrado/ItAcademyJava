package s104n1e3_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import s104n1e3.*;

class ContadorTest {

	
	@Test
	public void contadorIndexOutOfBoundsTest() {
		Contador contador = new Contador();
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, contador::counterIndexOutOfBounds);
		
	}
	
	

}
