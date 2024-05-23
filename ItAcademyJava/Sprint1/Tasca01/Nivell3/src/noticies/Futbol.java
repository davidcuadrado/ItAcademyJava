package noticies;

public class Futbol extends Noticia {
	
	private String competicio;
	private String club;
	private String jugador;
	
	public Futbol(String titular, String competicio, String club, String jugador) {
		super(titular);
		this.preu = 300;
		this.competicio = competicio;
		this.club = club;
		this.jugador = jugador;
		this.puntuacio = 5;
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

	public String getJugador() {
		return jugador;
	}

	public void setJugador(String jugador) {
		this.jugador = jugador;
	}
	
	public short calcularPreuNoticia() {
		short preuNoticia = 300;
		if (this.competicio.equalsIgnoreCase("lliga de campions")) {
			preuNoticia += 100;
		}
		if (this.club.equalsIgnoreCase("barça") || this.club.equalsIgnoreCase("madrid")) {
			preuNoticia += 100;
		}
		if (this.jugador.equalsIgnoreCase("Ferran Torres") || this.jugador.equalsIgnoreCase("Benzema")) {
			preuNoticia += 50;
		}
		
		return preuNoticia;
	}
	
	public final byte calcularPuntuacio() {
		byte puntuacio = 5;
		
		if (this.competicio.equalsIgnoreCase("lliga de campions")) {
			puntuacio += 3;
		} else if (this.competicio.equalsIgnoreCase("lliga")) {
			puntuacio += 2;
		}
		
		if (this.club.equalsIgnoreCase("barça") || this.club.equalsIgnoreCase("madrid")) {
			puntuacio += 1;
		}
		
		if (this.jugador.equalsIgnoreCase("Ferran Torres") || this.jugador.equalsIgnoreCase("Benzema")) {
			puntuacio += 1;
		}
		
		return puntuacio;
	}
	
	
	
	
	
	
	
	
	

}
