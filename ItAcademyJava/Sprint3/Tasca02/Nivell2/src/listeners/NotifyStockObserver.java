package listeners;

import notifiers.Stock;

public class NotifyStockObserver implements StockObserver {

	private String observerDirection;

	public NotifyStockObserver(String observerDirection) {
		this.observerDirection = observerDirection;
	}

	public void update(String eventType, Stock stockEntity) {
		System.out.println("Alert sent to " + observerDirection + ": stock value on " + stockEntity.getName()
				+ " has changed and a new value has been setted to: " + stockEntity.getValue() + " due " + eventType
				+ " operation performed ");
	}

	public String getObserverDirection() {
		return observerDirection;
	}

}
