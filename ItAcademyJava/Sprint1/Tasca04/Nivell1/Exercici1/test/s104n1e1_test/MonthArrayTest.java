package s104n1e1_test;

import s104n1e1.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class MonthArrayTest {
	
	Gestion gestion1 = new Gestion();
	/*
	@BeforeEach
	public void setUp() {
	gestion1 = new Gestion();
	ArrayList<Month> monthList = gestion1.monthListGen();
	}
	*/
	
	@Test
	public void testPositionsMax(ArrayList<Month> monthList) {
		System.out.println("La llista té 12 posicions: ");
		Assertions.assertTrue(monthList.size() == 12);
	}
	
	@Test
	public void testNull(ArrayList<Month> monthList) {
		System.out.println("La llista amb els mesos no és nul·la: ");
		Assertions.assertNotNull(monthList);
	}
	
	@Test
	public void testAgost8(ArrayList<Month>monthList) {
		System.out.println("En la seva posició 8 conté \"agost\": ");
		Assertions.assertEquals(monthList.get(8).getMonthName(), "agost");
	}
	

}