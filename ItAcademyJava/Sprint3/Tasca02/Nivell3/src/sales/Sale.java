package sales;

import java.util.ArrayList;

public class Sale {

	private ArrayList<Shoe> shoeList;
	private int saleTotal;

	public Sale(ArrayList<Shoe> shoeList) {
		this.shoeList = shoeList;
		this.saleTotal = saleTotalCalc();
	}

	public int saleTotalCalc() {
		int saleTotal = 0;

		for (Shoe shoe : this.shoeList) {
			saleTotal += shoe.getPrice();
		}

		return saleTotal;
	}

}
