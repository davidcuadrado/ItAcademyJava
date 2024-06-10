package s107n1e1_treballadors;

public class TreballadorOnline extends Treballador{
	
	private final int preuTarifaPlana;

	public TreballadorOnline(String nom, String cognom, int preuPerHora, int preuTarifaPlana) {
		super(nom, cognom, preuPerHora);
		TreballadorOnline.preuTarifaPlana = preuTarifaPlana;
		
	}
	

	@Override
	public int calcularSou(int horesTreballadesMes) {
		return ((horesTreballadesMes*preuPerHora)+preuTarifaPlana);
	}


	@Override
	public String toString() {
		return "TreballadorOnline [nom=" + nom + ", cognom=" + cognom + ", preuPerHora=" + preuPerHora + "]";
	}

	
	

}
