package s107n2e1;

import java.io.Serializable;

@Serializar (rutaArchivo = "C:\\Users\\r610c\\Desktop\\IT Academy\\Eclipse\\S107N2E1\\src\\persona_serializada")

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
