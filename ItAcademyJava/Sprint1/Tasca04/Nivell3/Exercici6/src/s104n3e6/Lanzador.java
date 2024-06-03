package s104n3e6;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;

public class Lanzador {


	public ThrowingCallable lanzadorIndexOutOfBounds() throws ArrayIndexOutOfBoundsException {
		
		throw new ArrayIndexOutOfBoundsException("Error en la ejecución ");
		
	}

}
