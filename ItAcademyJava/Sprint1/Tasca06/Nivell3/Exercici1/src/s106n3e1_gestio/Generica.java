package s106n3e1_gestio;

public class Generica {

	public <T extends Telefon> void mostrarNom(T t) {
		t.trucar();
	}

	public <S extends Smartphone> void resolucioFoto(S s) {
		s.ferFotos();
	}

}
