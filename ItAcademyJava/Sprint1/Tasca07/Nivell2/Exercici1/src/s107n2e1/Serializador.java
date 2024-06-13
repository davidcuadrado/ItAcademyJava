package s107n2e1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Serializador {

	public static void serializarPersona() {
		Persona personaAdd = personaDatos();

		if (personaAdd.getClass().isAnnotationPresent(Serializar.class)) {
			Serializar persona = personaAdd.getClass().getAnnotation(Serializar.class);
			String rutaArchivo = persona.rutaArchivo();
			File personaSerializada = new File(rutaArchivo, personaAdd.getClass()+ ".json");

			try (FileOutputStream serializandoPersona = new FileOutputStream(personaSerializada, true);
					ObjectOutputStream finSerializacion = new ObjectOutputStream(serializandoPersona)){
				finSerializacion.writeObject(personaAdd);
			} catch (IOException e) {
				System.out.println("Error en la escritura del archivo. ");
			}
		}
	}
	
	public static Persona personaDatos() {
		Persona personaAdd = null;
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Introdueix el nom: ");
				String nom = sc.nextLine();
				System.out.print("Introdueix el cognom: ");
				String cognom = sc.nextLine();
				System.out.print("Introdueix l'edat: ");
				int edat = sc.nextInt();
				
				personaAdd = new Persona(nom, cognom, edat);
					
				} catch (InputMismatchException e) {
					System.out.println("Error en la introducción de datos. ");
				}
		return personaAdd;
	}
}

