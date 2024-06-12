package s106n2e2;

public class Persona {

	private String nom;
	private String cognom;
	private int edat;

	public Persona(String nom, String cognom, int edat) {
		this.nom = nom;
		this.cognom = cognom;
		this.edat = edat;
	}

	@Override
	public String toString() {
		return "Persona: " + nom + " " + cognom + ", " + edat + ". ";
	}

}
