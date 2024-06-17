package s107n3e1;

import java.io.IOException;
import java.io.Serializable;

import java.lang.reflect.*;
import java.lang.Class;

public class Main {
	

	public static void main(String[] args) {
		
		// Bloque Java Reflection
		try {
			
			Class<Persona> reflect = Persona.class;
			Persona persona = new Persona("test", "ing", 10);
			if(persona.getClass().getAnnotation(SerializarJSON.class) != null) {
				 SerializarJSON anotacionJSON = persona.getClass().getAnnotation(SerializarJSON.class);
				 System.out.println(anotacionJSON);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// Ejecución del programa
		
		try {
			
		Serializador.serializarPersona();
		} catch (IOException e) {
			System.out.println("Error en la ruta del directorio. ");
		}

	}

}
