package s107n1e1_treballadors;

public class Treballador {
	protected String nom;
	protected String cognom;
	protected int preuPerHora;
	
	
	public Treballador(String nom, String cognom, int preuPerHora) {
		super();
		this.nom = nom;
		this.cognom = cognom;
		this.preuPerHora = preuPerHora;
	}


	public int calcularSou(int horesTreballades	) {
		return preuPerHora*horesTreballades;
	}


	@Override
	public String toString() {
		return "Treballador [nom=" + nom + ", cognom=" + cognom + ", preuPerHora=" + preuPerHora + "]";
	}
	
	

}
