package corte_irlandes;

public class Appliance extends Product{
	
	private final float consumption;
	private final int fabricationDate;
	private final float capacity;
	private final static int warranty = 18;
	
	
	public Appliance(String name, String brand, float price, int stock, int purchaseDate, float discount,
			float consumption, int fabricationDate, float capacity) {
		super(name, brand, price, stock, purchaseDate, discount);
		this.consumption = consumption;
		this.fabricationDate = fabricationDate;
		this.capacity = capacity;
	}


	public float getConsumption() {
		return consumption;
	}


	public int getFabricationDate() {
		return fabricationDate;
	}


	public float getCapacity() {
		return capacity;
	}


	public static int getWarranty() {
		return warranty;
	}


	@Override
	public String toString() {
		return "Appliance [consumption=" + consumption + ", fabricationDate=" + fabricationDate + ", capacity="
				+ capacity + ", idCode=" + idCode + ", name=" + name + ", brand=" + brand + ", price=" + price
				+ ", stock=" + stock + ", purchaseDate=" + purchaseDate + ", discount=" + discount + "]";
	}
	
	
	
	

}
