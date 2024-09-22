package s302n2;

import notifiers.*;
import listeners.*;

public class Principal {

	public static void main(String[] args) {
		Editor itAcademyEditor = new Editor();
		Editor barcelonActivaEditor = new Editor();

		LogOpenObserver logObserverITA = new LogOpenObserver("ITAcademy");
		NotifyStockObserver notifyDavid = new NotifyStockObserver("David");
		NotifyStockObserver notifyAleixandre = new NotifyStockObserver("Aleixandre");

		itAcademyEditor.events.subscribe("open", logObserverITA); // print1
		itAcademyEditor.events.subscribe("save", notifyDavid);
		itAcademyEditor.events.subscribe("save", notifyAleixandre);
		itAcademyEditor.events.subscribe("modify", notifyDavid);

		itAcademyEditor.openStock("ITAcademy", (byte) 95.5);
		itAcademyEditor.saveStock();

		barcelonActivaEditor.openStock("BarcelonActiva", (byte) 56);

		LogOpenObserver logObserverBA = new LogOpenObserver("BarcelonActiva");
		barcelonActivaEditor.events.subscribe("open", logObserverBA);
		barcelonActivaEditor.events.subscribe("save", notifyAleixandre);

		itAcademyEditor.modifyStock((byte) 5);
		itAcademyEditor.modifyStock((byte) 8);
		itAcademyEditor.saveStock();

		itAcademyEditor.events.unsubscribe("save", notifyDavid);

		itAcademyEditor.modifyStock((byte) 10);
		barcelonActivaEditor.modifyStock((byte) -32);

		itAcademyEditor.saveStock();
		barcelonActivaEditor.saveStock();

	}

}
