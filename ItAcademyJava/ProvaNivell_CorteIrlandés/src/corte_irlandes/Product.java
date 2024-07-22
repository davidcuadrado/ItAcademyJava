package corte_irlandes;

public class Product {
	
	protected final int idCode;
	protected static int counter = 0;
	protected String name;
	protected String brand;
	protected float price;
	protected int stock;
	protected int purchaseDate;
	protected float discount;
	
	public Product(String name, String brand, float price, int stock, int purchaseDate, float discount) {
		this.idCode = ++Product.counter;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.stock = stock;
		this.purchaseDate = purchaseDate;
		this.discount = discount;
	}
	
	
	

}
