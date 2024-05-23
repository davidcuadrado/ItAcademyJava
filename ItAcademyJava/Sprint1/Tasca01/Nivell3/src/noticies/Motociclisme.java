package noticies;

public class Motociclisme extends Noticia{
	
	private String equip;

	public Motociclisme(String titular, String equip) {
		super(titular);
		this.preu = 100;
		this.equip = equip;
		this.puntuacio = 3;
	}

	public String getEquip() {
		return equip;
	}

	public void setEquip(String equip) {
		this.equip = equip;
	}
	
	
	public short calcularPreuNoticia() {
		short preuNoticia = 100;
		
		if (this.equip.equalsIgnoreCase("honda") || this.equip.equalsIgnoreCase("yamaha")) {
			preuNoticia += 50;
		}
		
		return preuNoticia;
	}
	
	public byte calcularPuntuacio() {
		byte puntuacio = 3;
		
		if (this.equip.equalsIgnoreCase("honda") || this.equip.equalsIgnoreCase("yamaha")) {
			puntuacio += 3;
		}
		
		return puntuacio;
	}

}
