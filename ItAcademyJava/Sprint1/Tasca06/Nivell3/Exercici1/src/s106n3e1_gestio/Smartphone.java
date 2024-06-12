package s106n3e1_gestio;

public class Smartphone implements Telefon {

	public void ferFotos() {
		System.out.println("S'ha fet una foto. ");
	}

	@Override
	public void trucar() {
		System.out.println("Trucant. ");
	}

}
