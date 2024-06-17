package s107n3e1;

import java.io.Serializable;

@SerializarJSON(rutaArchivo = "D:\\00proyectos\\S107N3E1\\")
public class Persona implements Serializable {
	private String nom;
	private String cognom;
	private int edat;
	
	
	Persona(String nom, String cognom, int edat) {
		super();
		this.nom = nom;
		this.cognom = cognom;
		this.edat = edat;
	}

	public String getNom() {
		return nom;
	}

	public String getCognom() {
		return cognom;
	}

	public int getEdat() {
		return edat;
	}

	
	


	
	
	
	
	

}
