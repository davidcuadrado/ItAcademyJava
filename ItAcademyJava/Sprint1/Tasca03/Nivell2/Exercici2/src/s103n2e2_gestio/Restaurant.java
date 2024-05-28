package s103n2e2_gestio;

import java.util.Objects;

public class Restaurant implements Comparable<Restaurant> {
	
	private String nom;
	private int puntuacio;
	
	public Restaurant(String nom, int puntuacio) {
		this.nom = nom;
		this.puntuacio = puntuacio;
	}
	
	public String getNom() {
		return nom;
	}

	public int getPuntuacio() {
		return puntuacio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nom, puntuacio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return Objects.equals(nom, other.nom) && puntuacio == other.puntuacio;
	}

	@Override
	public String toString() {
		return "Restaurant: " + nom + ", amb puntuació: " + puntuacio + ". \n";
	}

	@Override
	public int compareTo(Restaurant e) {
		return getNom().compareTo(e.getNom());
	}
	
	
	public int compareTo(Object o1, Object o2) {
		Restaurant e1 = (Restaurant) o1;
		Restaurant e2 = (Restaurant) o2;
		return compareTo(e1.getPuntuacio(), e2.getPuntuacio());
	}

	
}
