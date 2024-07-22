package corte_irlandes;


import java.util.AbstractMap.SimpleEntry;

public class Electronic extends Product{
	
	private final SimpleEntry<Integer, Integer> resolution;
	private int batery;
	private final static int warranty = 9;
	
	
	public Electronic(String name, String brand, float price, int stock, int purchaseDate, float discount,
			SimpleEntry<Integer, Integer> resolution, int batery) {
		super(name, brand, price, stock, purchaseDate, discount);
		this.resolution = resolution;
		this.batery = batery;
	}


	public int getBatery() {
		return batery;
	}


	public void setBatery(int batery) {
		this.batery = batery;
	}


	public SimpleEntry<Integer, Integer> getResolution() {
		return resolution;
	}


	public static int getWarranty() {
		return warranty;
	}


	@Override
	public String toString() {
		return "Electronic [resolution=" + resolution + ", batery=" + batery + ", idCode=" + idCode + ", name=" + name
				+ ", brand=" + brand + ", price=" + price + ", stock=" + stock + ", purchaseDate=" + purchaseDate
				+ ", discount=" + discount + "]";
	}
	
	
	
	
	
	

	
	
	
	

}
