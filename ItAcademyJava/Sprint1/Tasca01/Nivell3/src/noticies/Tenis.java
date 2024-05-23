package noticies;

public class Tenis extends Noticia{
	
	private String competicio;
	private String tenista;
	
	public Tenis(String titular, String competicio, String tenista) {
		super(titular);
		this.preu = 150;
		this.competicio = competicio;
		this.tenista = tenista;
		this.puntuacio = 4;
	}

	public String getCompeticio() {
		return competicio;
	}

	public void setCompeticio(String competicio) {
		this.competicio = competicio;
	}

	public String getTenista() {
		return tenista;
	}

	public void setTenista(String tenista) {
		this.tenista = tenista;
	}
	
	
	public short calcularPreuNoticia() {
		short preuNoticia = 150;

		if (this.tenista.equalsIgnoreCase("Federer") || this.tenista.equalsIgnoreCase("Nadal") || this.tenista.equalsIgnoreCase("Djokovic")) {
			preuNoticia += 100;
		}
		
		return preuNoticia;
	}
	
	public byte calcularPuntuacio() {
		byte puntuacio = 4;
		
		if (this.tenista.equalsIgnoreCase("Federer") || this.tenista.equalsIgnoreCase("Nadal") || this.tenista.equalsIgnoreCase("Djokovic")) {
			puntuacio += 3;
		}
		
		return puntuacio;
	}
	
	

}
