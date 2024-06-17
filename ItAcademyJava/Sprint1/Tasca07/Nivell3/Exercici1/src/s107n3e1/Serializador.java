package s107n3e1;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;



public class Serializador {
	


	public static void serializarPersona() throws IOException {
		Persona personaSerializable = new Persona("Dividendo", "Perez", 36);

		try {
			SerializarJSON serializarJSON = personaSerializable.getClass().getAnnotation(SerializarJSON.class);
			String rutaGuardarArchivo = serializarJSON.rutaArchivo();
			File archivo = new File(rutaGuardarArchivo, personaSerializable.getClass() + "_"
					+ personaSerializable.getCognom() + "_" + personaSerializable.getNom() + ".json");

			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(archivo, personaSerializable);
			
			System.out.println("Se ha llevado a cabo la serialización correctamente. ");

		} catch (RuntimeException e) {
			System.out.println("Algo salió mal. Comrpueba la relación entre anotació y clase. ");
		}

	}
		

}
