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
	}
	
	
	@Test
	public void testPositionsMax() {
		List<String> monthList = gestion1.monthListGen();
		Assertions.assertTrue(monthList.size() == 12);
	}
	
	@Test
	public void testNull() {
		List<String> monthList = gestion1.monthListGen();
		Assertions.assertNotNull(monthList);
	}
	
	@Test
	public void testAgost8() {
		List<String> monthList = gestion1.monthListGen();
		//Nos lanza un failure ya que la posición del mes "agost" es 7
		Assertions.assertEquals(monthList.get(8), "agost");
	}
	

}
