package gestio;

import java.util.ArrayList;
import exceptions.*;

public class Venda {

	private ArrayList<Producte> llistaVenda;
	private int preuTotal;

	public Venda(ArrayList<Producte> llistaVenda) {
		this.llistaVenda = llistaVenda;
		this.preuTotal;
	}

	public ArrayList<Producte> getLlistaVenda() {
		return llistaVenda;
	}

	public void setLlistaVenda(ArrayList<Producte> llistaVenda) {
		this.llistaVenda = llistaVenda;
	}

	public int getPreuTotal() {
		return preuTotal;
	}

	public void setPreuTotal(int preuTotal) {
		this.preuTotal = preuTotal;
	}

	public int calcularTotal() throws VendaBuidaException {
		int sumatoriPreus = 0;

		if (llistaVenda.size() == 0) {
			throw new VendaBuidaException("Per fer una venda primer has d’afegir productes");
		} else {
			for (int i = 0; i < llistaVenda.size(); i++) {
				sumatoriPreus += llistaVenda.get(i).getPreu();
			}
		}
		return sumatoriPreus;

	}
}
