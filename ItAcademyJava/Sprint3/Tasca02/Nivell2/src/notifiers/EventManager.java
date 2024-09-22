package notifiers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import listeners.*;

public class EventManager {
	
	Map<String, List<StockObserver>> observerList = new HashMap<>();
	
	public EventManager(String... variations) {
		for (String variation : variations) {
			this.observerList.put(variation, new ArrayList<>());
		}
	}
	
	public void subscribe(String eventType, StockObserver observer) {
		List<StockObserver> subscriberList = observerList.get(eventType);
		subscriberList.add(observer);
	}
	
	public void unsubscribe(String eventType, StockObserver observer) {
		List<StockObserver> subscriberList = observerList.get(eventType);
		subscriberList.remove(observer);
	}
	
    public void notify(String eventType, Stock stock) {
        List<StockObserver> subscriberList = observerList.get(eventType);
        for (StockObserver observer : subscriberList) {
        	observer.update(eventType, stock);
        }
    }

	public Map<String, List<StockObserver>> getObserverList() {
		return observerList;
	}
    
    

}
