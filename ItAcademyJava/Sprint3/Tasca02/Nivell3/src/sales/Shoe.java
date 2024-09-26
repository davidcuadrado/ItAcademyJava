package sales;

public class Shoe {

	private String brand;
	private String model;
	private String color;
	private int price;

	public Shoe(String brand, String model, String color, int price) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

}
