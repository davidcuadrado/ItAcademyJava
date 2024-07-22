package corte_irlandes;

public class Beauty extends Product {
	
	private final boolean vegan;
	private enum season {SPRING, SUMMER, AUTUMN, WINTER}
	
	
	public Beauty(String name, String brand, float price, int stock, int purchaseDate, float discount, boolean vegan) {
		super(name, brand, price, stock, purchaseDate, discount);
		this.vegan = vegan;
	}


	public boolean isVegan() {
		return vegan;
	}


	@Override
	public String toString() {
		return "Beauty [vegan=" + vegan + ", idCode=" + idCode + ", name=" + name + ", brand=" + brand + ", price="
				+ price + ", stock=" + stock + ", purchaseDate=" + purchaseDate + ", discount=" + discount + "]";
	}
	
	
	

}
