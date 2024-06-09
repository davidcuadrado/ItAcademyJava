package s107n2e1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Serializador {

	public static void serializarPersona() {
		Persona personaAdd = personaDatos();

		if (personaAdd.getClass().isAnnotationPresent(Serializar.class)) {
			Serializar persona = personaAdd.getClass().getAnnotation(Serializar.class);
			String rutaArchivo = persona.rutaArchivo();
			File personaSerializada = new File(rutaArchivo, personaAdd.getClass().getName() + ".txt");

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
					
				} catch (Exception e) {
					System.out.println("Algo salió mal. ");
				}
		return personaAdd;
				
				
		
	}
}

/*
 * public static void serializeObject() { Employee newUser1 = new
 * Employee("Ricardo", "Smith", 4);
 * 
 * if (newUser1.getClass().isAnnotationPresent(JSONSerializer.class)) {
 * JSONSerializer annotation =
 * newUser1.getClass().getAnnotation(JSONSerializer.class); String directory =
 * annotation.directory(); File serializedEmployeeFile = new File(directory,
 * newUser1.getClass().getSimpleName() + ".json");
 * 
 * try (FileOutputStream fos = new FileOutputStream(serializedEmployeeFile);
 * ObjectOutputStream oos = new ObjectOutputStream(fos)) {
 * oos.writeObject(newUser1); } catch (IOException e) { e.printStackTrace(); }
 * 
 * }
 * 
 * }
 */
