package s107n1e2_main;

import s107n1e2_treballadors.*;

public class Principal {

	public static void main(String[] args) {
		showOverrideDif();
		showDeprecated();

	}

	public static void showOverrideDif() {
		Treballador treballador1 = new Treballador("Josep", "Vila", 25);
		TreballadorOnline treballadorOnline1 = new TreballadorOnline("Francisco", "Sabaté", 25, 20);
		TreballadorPresencial treballadorPresencial1 = new TreballadorPresencial("Ada", "Martí", 25, 200);
		final int horesTreballadesMes = 160;

		System.out.println(treballador1.toString() + " Rebrà un import de "
				+ treballador1.calcularSou(horesTreballadesMes) + "€. ");
		System.out.println(treballadorOnline1.toString() + " Rebrà un import de "
				+ treballadorOnline1.calcularSou(horesTreballadesMes) + "€. ");
		System.out.println(treballadorPresencial1.toString() + " Rebrà un import de "
				+ treballadorPresencial1.calcularSou(horesTreballadesMes) + "€. ");

	}

	@SuppressWarnings("deprecation")
	public static void showDeprecated() {

		TreballadorOnline tO2 = new TreballadorOnline("Pere", "Solé", 25, 20);
		TreballadorPresencial tP2 = new TreballadorPresencial("Enric", "Rueda", 25, 200);
		System.out.println("\nBefore using deprecated method: ");
		System.out.println(tO2.toString());
		System.out.println(tP2.toString());

		tO2.bonificarHoresTreball(16000);
		tP2.rebaixarSou(1);
		System.out.println("\nAfter using deprecated method: ");
		System.out.println(tO2.toString());
		System.out.println(tP2.toString());

	}

}
