package notifiers;

public class Stock {

	private String name;
	private byte value;

	public Stock(String name, byte value) {
		this.name = name;
		this.value = value;
	}

	public Stock(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public byte getValue() {
		return value;
	}

	public void modifyValue(byte modValue) {
		this.value += modValue;

	}

}
