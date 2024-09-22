package listeners;

import notifiers.Stock;

public class LogOpenObserver implements StockObserver {

	private Stock stockLog;

	public LogOpenObserver(String name) {
		this.stockLog = new Stock(name);
	}

	public void update(String eventType, Stock stockEntity) {
		System.out.println("Log input on " + stockLog.getName() + ": stock value on " + stockEntity.getName()
				+ " has changed and a new value has been setted to: " + stockEntity.getValue() + " due " + eventType
				+ " operation performed ");
	}

}
