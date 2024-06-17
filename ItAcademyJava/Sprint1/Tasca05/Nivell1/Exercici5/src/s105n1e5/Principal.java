package s105n1e5;

public class Principal {

	public static void main(String[] args) {

		Alfabetico.iniciar();
		Alfabetico alfa1 = new Alfabetico(Alfabetico.directory);

		// Exercici1: Alfabetico.ordenarDirectorio(Alfabetico.directory);
		// Exercici2: Alfabetico.listarArbolDirectorio(Alfabetico.directoryFile);
		// Exercici3: Alfabetico.txtArbolDirectorio(Alfabetico.directoryFile);
		// Exercici4: Alfabetico.readtxt(Alfabetico.directoryFile);
		Alfabetico.serializar(alfa1);
		Alfabetico.deserializar(alfa1);
		
	}

}