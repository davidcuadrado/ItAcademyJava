package test;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import s104n1e1.*;

class MonthArrayTest {
	
	Gestion gestion1 = new Gestion();
	
	@BeforeEach
	void setUp() {
	gestion1 = new Gestion();
	}
	
	
	@Test
	void testPositionsMax() {
		ArrayList<Month> monthList = gestion1.monthListGen();
		System.out.println("La llista té 12 posicions: ");
		Assertions.assertTrue(monthList.size() == 12);
	}
	
	@Test
	void testNull() {
		ArrayList<Month> monthList = gestion1.monthListGen();
		System.out.println("La llista amb els mesos no és nul·la: ");
		Assertions.assertNotNull(monthList);
	}
	
	@Test
	void testAgost8() {
		ArrayList<Month> monthList = gestion1.monthListGen();
		System.out.println("En la seva posició 8 conté \"agost\": ");
		//Nos lanza un failure ya que la posición del mes "agost" es 7
		Assertions.assertEquals(monthList.get(8).getMonthName(), "agost");
	}
	

}
