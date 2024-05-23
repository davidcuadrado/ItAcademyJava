package s102n1e1;

import java.util.ArrayList;

import exceptions.*;
import gestio.Producte;
import gestio.Venda;

public class S102N1E1_main {

	public static void main(String[] args) {

		ArrayList<Producte> venda1List = new ArrayList<Producte>();
		ArrayList<Producte> venda2List = new ArrayList<Producte>();

		Producte producte1 = new Producte("carbassa", 5);
		Producte producte2 = new Producte("pastanaga", 2);
		Producte producte3 = new Producte("pebrot", 3);
		Producte producte4 = new Producte("tomàquets", 1);

		venda1List.add(producte1);
		venda1List.add(producte2);
		venda1List.add(producte3);
		venda1List.add(producte4);

		Venda venda1 = new Venda(venda1List);
		Venda venda2 = new Venda(venda2List);

		try {
			int preuTotal1 = venda1.calcularTotal();
			venda1.setPreuTotal(preuTotal1);

			System.out.println("Con la compra de cinco productos, ¡te llevas el quinto gratis!");

			try {
				int descuento = venda1List.get(4).getPreu();
				preuTotal1 -= descuento;
				venda1.setPreuTotal(preuTotal1);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Tu lista de la compra no contiene los productos suficientes. ");
			}

			System.out.println("El precio final de tu compra es: " + venda1.getPreuTotal() + ". ");
		} catch (VendaBuidaException e) {
			System.out.println("Per fer una venda primer has d’afegir productes");
		}

		try {
			int preuTotal2 = venda2.calcularTotal();
			venda2.setPreuTotal(preuTotal2);
		} catch (VendaBuidaException e) {
			System.out.println("\nPara hacer una venta primero has de añadir productos. ");
		}

	}

}
