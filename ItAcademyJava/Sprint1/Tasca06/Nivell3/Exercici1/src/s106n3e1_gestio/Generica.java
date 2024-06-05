package s106n3e1_gestio;

public class Generica {

	public static <T extends Telefon> void mostrarNom(T telefon) {
		telefon.trucar();
	}

	public static <S extends Smartphone> void resolucioFoto(S smartphone) {
		smartphone.ferFotos();
		smartphone.trucar();
	}

}
