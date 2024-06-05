package s106n3e1_main;

import s106n3e1_gestio.*;

public class Principal {

	public static void main(String[] args) {
		Smartphone galaxy = new Smartphone();
		Generica generic = new Generica();

		generic.mostrarNom(galaxy);
		generic.resolucioFoto(galaxy);

	}

}
