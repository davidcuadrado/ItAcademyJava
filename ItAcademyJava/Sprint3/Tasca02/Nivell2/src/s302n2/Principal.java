package s302n2;

import notifiers.*;
import listeners.*;

public class Principal {


	public static void main(String[] args) {
		Editor itAcademyEditor = new Editor();
		Editor barcelonActivaEditor = new Editor();

		itAcademyEditor.events.subscribe("open", new LogOpenObserver("ITAcademy"));
		itAcademyEditor.events.subscribe("save", new NotifyStockObserver("David"));
		itAcademyEditor.events.subscribe("save", new NotifyStockObserver("Aleixandre"));
		itAcademyEditor.events.subscribe("modify", new NotifyStockObserver("David"));
		
		itAcademyEditor.openStock("ITAcademy", (byte) 95.5);
		itAcademyEditor.saveStock();
		
		barcelonActivaEditor.openStock("BarcelonActiva", (byte) 56);
		barcelonActivaEditor.events.subscribe("open", new LogOpenObserver("BarcelonActiva"));
		barcelonActivaEditor.events.subscribe("save", new NotifyStockObserver("Aleixandre"));
		
		
		itAcademyEditor.modifyStock((byte) 5);
		itAcademyEditor.modifyStock((byte) 8);
		
		itAcademyEditor.modifyStock((byte) 10);
		
		itAcademyEditor.saveStock();
		barcelonActivaEditor.saveStock();
		

	}

}
