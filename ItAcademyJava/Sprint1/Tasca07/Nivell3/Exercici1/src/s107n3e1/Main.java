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

/*public static void main(String[] args) {
try {
    // Obtener la clase
    Class<?> clazz = MiClase.class;
    
    // Crear una instancia de la clase
    Object obj = clazz.getDeclaredConstructor().newInstance();
    
    // Obtener todos los métodos de la clase
    Method[] methods = clazz.getDeclaredMethods();
    
    // Iterar sobre los métodos y verificar si están anotados con MiAnotacion
    for (Method method : methods) {
        if (method.isAnnotationPresent(MiAnotacion.class)) {
            // Obtener la anotación
            MiAnotacion anotacion = method.getAnnotation(MiAnotacion.class);
            
            // Imprimir el valor de la anotación
            System.out.println("Método: " + method.getName() + ", Valor de la anotación: " + anotacion.valor());
            
            // Invocar el método anotado
            method.invoke(obj);
        }
    }
} catch (Exception e) {
    e.printStackTrace();
}
}

*/
