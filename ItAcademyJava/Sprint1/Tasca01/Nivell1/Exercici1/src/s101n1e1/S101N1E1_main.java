package s101n1e1;

import Instruments.*;

public class S101N1E1_main {

	public static void main(String[] args) {
		
		Vent ventAdd = new Vent("SuperFlute 9000", 10);
		Corda cordaAdd = new Corda("Stradivarius X", 300000);
		Percussio percussioAdd = new Percussio("Tom Stomp 12", 30);
		
		ventAdd.tocar();
		cordaAdd.tocar();
		percussioAdd.tocar();

	}

}
