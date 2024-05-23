package noticies;

public class F1 extends Noticia{
	
	private String escuderia;
	
	
	public F1(String titular, String escuderia) {
		super(titular);
		this.preu = 100;
		this.escuderia = escuderia;
		this.puntuacio = 4;
	}

	public String getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}
	
	public short calcularPreuNoticia() {
		short preuNoticia = 100;
		
		if (this.escuderia.equalsIgnoreCase("ferrari") || this.escuderia.equalsIgnoreCase("mercedes")) {
			preuNoticia += 50;
		}
		
		return preuNoticia;
	}
	
	public byte calcularPuntuacio() {
		byte puntuacio = 4;
		
		if (this.escuderia.equalsIgnoreCase("ferrari") || this.escuderia.equalsIgnoreCase("mercedes")) {
			puntuacio += 2;
		}
		
		return puntuacio;
	}

}
