package corte_irlandes;

public class Clothing extends Product {
	
	private final String size;
	private final String fabric;
	private final String garment;
	
	public Clothing(String name, String brand, float price, int stock, int purchaseDate, float discount, String size,
			String fabric, String garment) {
		super(name, brand, price, stock, purchaseDate, discount);
		this.size = size;
		this.fabric = fabric;
		this.garment = garment;
	}

	public String getSize() {
		return size;
	}

	public String getFabric() {
		return fabric;
	}

	public String getGarment() {
		return garment;
	}

	
	@Override
	public String toString() {
		return "Clothing [size=" + size + ", fabric=" + fabric + ", garment=" + garment + ", idCode=" + idCode
				+ ", name=" + name + ", brand=" + brand + ", price=" + price + ", stock=" + stock + ", purchaseDate="
				+ purchaseDate + ", discount=" + discount + "]";
	}
	
	
	
	

}
