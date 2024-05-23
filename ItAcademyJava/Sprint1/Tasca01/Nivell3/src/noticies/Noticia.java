package noticies;

public abstract class Noticia {
	
	protected String titular;
	protected String text;
	protected byte puntuacio;
	protected short preu;
	
	public Noticia(String titular) {
		this.titular = titular;
		this.text = "";
		this.puntuacio = 0;
		this.preu = 0;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public byte getPuntuacio() {
		return puntuacio;
	}

	public void setPuntuacio(byte puntuacio) {
		this.puntuacio = puntuacio;
	}

	public short getPreu() {
		return preu;
	}

	public void setPreu(short preu) {
		this.preu = preu;
	}
	
	public abstract short calcularPreuNoticia();
	
	public abstract byte calcularPuntuacio();
	

}
