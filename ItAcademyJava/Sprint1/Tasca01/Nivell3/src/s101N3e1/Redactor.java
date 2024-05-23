package s101N3e1;

import java.util.ArrayList;
import noticies.*;

public class Redactor {
	
	private String nom;
	private final String dni;
	private static int sou = 1500;
	ArrayList<Noticia> noticiesLlista;
	
	
	public Redactor(String nom, String dni) {
		super();
		this.nom = nom;
		this.dni = dni;
		this.noticiesLlista = new ArrayList<Noticia>();
	}
	
	
	public static int getSou() {
		return sou;
	}
	public static void setSou(int sou) {
		Redactor.sou = sou;
	}
	
	public String getDni() {
		return dni;
	}
	
	public ArrayList<Noticia> getNoticiesLlista() {
		return noticiesLlista;
	}
	
	

}
