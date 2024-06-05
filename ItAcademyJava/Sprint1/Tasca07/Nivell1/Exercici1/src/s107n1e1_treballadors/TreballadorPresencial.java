package s107n1e1_treballadors;

public class TreballadorPresencial extends Treballador{
	
	private int benzina;
	
	
	public TreballadorPresencial(String nom, String cognom, int preuPerHora, int benzina) {
		super(nom, cognom, preuPerHora);
		this.benzina = benzina;
		
	}
	
	@Override
	public int calcularSou(int horesTreballadesMes) {
		return ((horesTreballadesMes*preuPerHora)+benzina);
	}

	@Override
	public String toString() {
		return "TreballadorPresencial [nom=" + nom + ", cognom=" + cognom + ", preuPerHora="
				+ preuPerHora + "]";
	}
	
	

}
