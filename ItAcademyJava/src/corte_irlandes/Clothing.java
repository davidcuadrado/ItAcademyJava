package corte_irlandes;

public class Clothing extends Product {
	
	private String size;
	private String fabric;
	private String garment;
	
	public Clothing(String name, String brand, float price, int stock, int purchaseDate, float discount, String size,
			String fabric, String garment) {
		super(name, brand, price, stock, purchaseDate, discount);
		this.size = size;
		this.fabric = fabric;
		this.garment = garment;
	}
	
	
	
	

}
