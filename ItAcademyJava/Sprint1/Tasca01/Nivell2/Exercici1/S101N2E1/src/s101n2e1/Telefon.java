package s101n2e1;

public class Telefon {
	
	protected String marca;
	protected String model;
	
	public Telefon(String marca, String model) {
		super();
		this.marca = marca;
		this.model = model;
	}
	
	public void trucar(String numTelefon) {
		System.out.println("S'està trucant al " + numTelefon + ". ");
		
	}

}
