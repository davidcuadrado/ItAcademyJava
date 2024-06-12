package s106n2e2;


public class Main {

	public static void main(String[] args) {
		String nom = "Lluis";
		String cognom = "Llach";
		int edat = 25;
		char lletra = 'L';
		Persona persona = new Persona(nom, cognom, edat);
		
		UndefinedTypeParameterization genericCall = new UndefinedTypeParameterization();
		
		genericCall.genericMethodUndefinedParameters(nom, cognom, lletra);
		
		genericCall.genericMethodUndefinedParameters(persona.toString(), edat, lletra);
		
		genericCall.genericMethodUndefinedParameters(lletra, edat, persona);
		
	}

}
