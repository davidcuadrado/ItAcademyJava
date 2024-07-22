package corte_irlandes;

public class Beauty extends Product {
	
	private boolean vegan;
	private enum season {SPRING, SUMMER, AUTUMN, WINTER}
	
	
	public Beauty(String name, String brand, float price, int stock, int purchaseDate, float discount, boolean vegan) {
		super(name, brand, price, stock, purchaseDate, discount);
		this.vegan = vegan;
	};
	
	

}
