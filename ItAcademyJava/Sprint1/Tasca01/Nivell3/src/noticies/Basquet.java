package noticies;

public class Basquet extends Noticia {
	
	private String competicio;
	private String club;
	
	public Basquet(String titular, String competicio, String club) {
		super(titular);
		this.preu = 250;
		this.competicio = competicio;
		this.club = club;
		this.puntuacio = 4;
	}

	public String getCompeticio() {
		return competicio;
	}

	public void setCompeticio(String competicio) {
		this.competicio = competicio;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}
	
	public short calcularPreuNoticia() {
		short preuNoticia = 250;
		if (this.competicio.equalsIgnoreCase("eurolliga")) {
			preuNoticia += 75;
		}
		if (this.club.equalsIgnoreCase("barça") || this.club.equalsIgnoreCase("madrid")) {
			preuNoticia += 75;
		}
		
		return preuNoticia;
	}
	
	public byte calcularPuntuacio() {
		byte puntuacio = 4;
		
		if (this.competicio.equalsIgnoreCase("eurolliga")) {
			puntuacio += 3;
		} else if (this.competicio.equalsIgnoreCase("ACB")) {
			puntuacio += 2;
		}
		
		if (this.club.equalsIgnoreCase("barça") || this.club.equalsIgnoreCase("madrid")) {
			puntuacio += 1;
		}
		
		return puntuacio;
	}
	
	

}
