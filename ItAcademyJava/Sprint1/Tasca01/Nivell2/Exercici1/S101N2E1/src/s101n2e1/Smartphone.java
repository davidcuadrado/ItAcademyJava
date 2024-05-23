package s101n2e1;

public class Smartphone extends Telefon
	implements Camera, Rellotge {

	public Smartphone(String marca, String model) {
		super(marca, model);
	}
	
	public void fotografiar() {
		System.out.println("S'està fent una foto. ");
	}
	
	public void alarma() {
		System.out.println("Està sonant la alarma. ");
	}
	
	

}
