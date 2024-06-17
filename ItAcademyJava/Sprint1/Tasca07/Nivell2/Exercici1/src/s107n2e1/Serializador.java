package s107n2e1;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;



public class Serializador {

	public static void serializarPersona() throws IOException {
		Persona personaSerializable = new Persona("Manel", "Perez", 36);
		
		try {
			SerializarJSON serializarJSON= personaSerializable.getClass().getAnnotation(SerializarJSON.class);
			String rutaGuardarArchivo = serializarJSON.rutaArchivo();
			File archivo = new File(rutaGuardarArchivo, personaSerializable.getClass()+"_"+personaSerializable.getCognom()+"_"+personaSerializable.getNom()+".json");
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(archivo, personaSerializable);
			
		} catch (RuntimeException e) {
			System.out.println("Algo salió mal. Comrpueba la relación entre anotació y clase. ");
		}

	}

}
