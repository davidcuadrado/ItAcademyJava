package s106n2e1;

public class Main {

	public static void main(String[] args) {
		String nom = "Lluis";
		String cognom = "Llach";
		int edat = 25;
		char lletra = 'L';
		Persona persona = new Persona(nom, cognom, edat);
		
		OneGenericParameter genericCall = new OneGenericParameter();
		
		genericCall.genericMethodOneString(nom, cognom, lletra);
		
		genericCall.genericMethodOneString(persona.toString(), edat, lletra);
		
	}

}
