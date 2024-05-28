package s103n3e1_gestion;

import java.util.Objects;

public class Persona implements Comparable<Persona>{
	private String nom;
	private String cognom;
	private String dni;
	
	public Persona(String nom, String cognom, String dni) {
		this.nom = nom;
		this.cognom = cognom;
		this.dni = dni;
	}
	
	
	

	public String getNom() {
		return nom;
	}

	public String getCognom() {
		return cognom;
	}

	public String getDni() {
		return dni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognom, dni, nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(cognom, other.cognom) && Objects.equals(dni, other.dni) && Objects.equals(nom, other.nom);
	}



	@Override
	public int compareTo(Persona e) {
		return getNom().compareTo(e.getNom());
	}

	@Override
	public String toString() {
		return "" + nom + "		" + cognom + "		" + dni + " ";
	}
	
	
	
	
	
	
	

}
