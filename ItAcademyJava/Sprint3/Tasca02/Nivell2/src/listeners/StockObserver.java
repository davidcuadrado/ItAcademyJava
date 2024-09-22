package listeners;

import notifiers.Stock;

public interface StockObserver {

	void update(String eventType, Stock stockEntity);

}
