package sales;

import java.util.ArrayList;

public class SaleGenerator {

	public Sale generateSale() {

		ArrayList<Shoe> shoeList = new ArrayList<Shoe>();
		Shoe shoe1 = new Shoe("Nike", "Air Max", "Black", 120);
		Shoe shoe2 = new Shoe("Adidas", "Ultraboost", "White", 150);
		Shoe shoe3 = new Shoe("Puma", "RS-X", "Red", 100);

		shoeList.add(shoe1);
		shoeList.add(shoe2);
		shoeList.add(shoe3);

		Sale sale1 = new Sale(shoeList);

		return sale1;

	}

}
