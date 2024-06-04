package s106n1e2;

public class Main {

	public static void main(String[] args) {
		String nom = "Lluis";
		String cognom = "Llach";
		int edat = 25;
		char lletra = 'L';
		Persona persona = new Persona(nom, cognom, edat);
		
		GenericMethods genericCall = new GenericMethods();
		
		genericCall.genericMethod(nom, cognom, lletra);
		
		genericCall.genericMethod(persona.toString(), edat, lletra);
		
		genericCall.genericMethod(lletra, edat, persona);
		
	}

}
