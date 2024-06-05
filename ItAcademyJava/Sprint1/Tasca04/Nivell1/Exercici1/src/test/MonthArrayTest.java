package test;

import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import s104n1e1.*;

class MonthArrayTest {
	
	Gestion gestion1 = new Gestion();
	
	@BeforeEach
	public void setUp() {
	gestion1 = new Gestion();
	gestion1.monthListGen();
	}
	
	
	@Test
	public void testPositionsMax() {
		gestion1 = new Gestion();
		List<String> monthList = gestion1.monthListGen();
		System.out.println("La llista té 12 posicions: ");
		Assertions.assertTrue(monthList.size() == 12);
	}
	
	@Test
	public void testNull() {
		gestion1 = new Gestion();
		List<String> monthList = gestion1.monthListGen();
		System.out.println("La llista amb els mesos no és nul·la: ");
		Assertions.assertNotNull(monthList);
	}
	
	@Test
	public void testAgost8() {
		gestion1 = new Gestion();
		List<String> monthList = gestion1.monthListGen();
		System.out.println("En la seva posició 8 conté \"agost\": ");
		//Nos lanza un failure ya que la posición del mes "agost" es 7
		Assertions.assertEquals(monthList.get(8), "agost");
	}
	

}
