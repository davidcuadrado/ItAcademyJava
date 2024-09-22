package notifiers;

public class Editor {

	public EventManager events;
	private Stock stock;

	public Editor() {
		this.events = new EventManager("open", "save", "modify");
	}

	public void openStock(String name, byte value) {
		this.stock = new Stock(name, value);
		events.notify("open", stock);
	}

	public void saveStock() {

		if (this.stock != null) {
			events.notify("save", stock);
		} else {
			System.out.println("This stock is not currently open. ");
		}
	}

	public void modifyStock(byte value) {
		if (this.stock != null) {
			this.stock.modifyValue(value);
			events.notify("modify", stock);
		} else {
			System.out.println("This stock cannot be modified. ");
		}
	}

}
