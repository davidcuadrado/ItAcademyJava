package s104n3e6;


import static org.assertj.core.api.Assertions.assertThatThrownBy;


import org.junit.jupiter.api.Test;

class Exercici6Test {

	@Test
	void outOfBoundsTest() throws ArrayIndexOutOfBoundsException{
		Lanzador lanzador1 = new Lanzador();
		
		assertThatThrownBy(lanzador1::lanzadorIndexOutOfBounds).isInstanceOf(ArrayIndexOutOfBoundsException.class);
		
	}

}
