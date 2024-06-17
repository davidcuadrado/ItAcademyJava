package s107n2e1;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		try {
		Serializador.serializarPersona();
		} catch (IOException e) {
			System.out.println("Error en la ruta del directorio. ");
		}

	}

}
