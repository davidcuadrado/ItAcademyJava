package corte_irlandes;

public class Product {
	
	protected final int idCode;
	protected static int counter = 0;
	protected final String name;
	protected final String brand;
	protected float price;
	protected int stock;
	protected final int purchaseDate;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public int getIdCode() {
		return idCode;
	}

	public String getName() {
		return name;
	}

	public String getBrand() {
		return brand;
	}

	public int getPurchaseDate() {
		return purchaseDate;
	}
	
	/*
	public static void applyDiscount() {
		// float discountPercentage = (0-100)
				// Product.discount = discountPercentage/100
				// Product.price = price * discount;
	}
	*/

	@Override
	public String toString() {
		return "Product [idCode=" + idCode + ", name=" + name + ", brand=" + brand + ", price=" + price + ", stock="
				+ stock + ", purchaseDate=" + purchaseDate + ", discount=" + discount + "]";
	}
	
	
		
	
	

}
