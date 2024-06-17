package s105n1e5;

public class Principal {

	public static void main(String[] args) {

		Alfabetico.iniciar();
		Alfabetico alfa1 = new Alfabetico(Alfabetico.directory);

		Alfabetico.serializar(alfa1);
		Alfabetico.deserializar(alfa1);
		
	}

}
