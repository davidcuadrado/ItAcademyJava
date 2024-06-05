package s107n1e1_main;

import s107n1e1_treballadors.*;

public class Principal {

	public static void main(String[] args) {
		showOverrideDif();
		
	}
	
	
	public static void showOverrideDif() {
		Treballador treballador1 = new Treballador("Josep", "Vila", 25);
		TreballadorOnline treballadorOnline1 = new TreballadorOnline("Francisco", "Sabaté", 25, 20);
		TreballadorPresencial treballadorPresencial1 = new TreballadorPresencial("Ada", "Martí", 25, 200);
		final int horesTreballadesMes = 160;
		
		System.out.println(treballador1.toString() + " Rebrà un import de "+ treballador1.calcularSou(horesTreballadesMes)+"€. ");
		System.out.println(treballadorOnline1.toString() + " Rebrà un import de "+treballadorOnline1.calcularSou(horesTreballadesMes)+"€. ");
		System.out.println(treballadorPresencial1.toString() +" Rebrà un import de "+ treballadorPresencial1.calcularSou(horesTreballadesMes)+"€. ");
		
		
	}

}
