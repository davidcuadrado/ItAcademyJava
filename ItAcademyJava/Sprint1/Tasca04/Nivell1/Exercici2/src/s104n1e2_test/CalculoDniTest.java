package s104n1e2_test;

import s104n1e2.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class CalculoDniTest {
	
	CalculoDni calculoDni1 = new CalculoDni();
	ArrayList<Integer> dniList = new ArrayList<Integer>();
	
	@BeforeEach
	public void setUp(){
		dniList = null;
		calculoDni1 = new CalculoDni();
		dniListAdd();
		
		
	}
	
	@ParameterizedTest
	public void lengthTest(ArrayList<Integer> dniList) {
		for (int i = 0; i<dniList.size(); i++) {
			int dni = dniList.get(i);
			calculoDni1.calcularLletra(dni);
		}
				
	}
	
	public void dniListAdd() {
		int dni1 = 42867998;
		int dni2 = 26758945;
		int dni3 = 35794685;
		int dni4 = 84259668;
		int dni5 = 26574816;
		int dni6 = 94281519;
		int dni7 = 98782884;
		int dni8 = 38129874;
		int dni9 = 15284856;
		int dni10 = 95515619;
		
		dniList.add(dni1);
		dniList.add(dni2);
		dniList.add(dni3);
		dniList.add(dni4);
		dniList.add(dni5);
		dniList.add(dni6);
		dniList.add(dni7);
		dniList.add(dni8);
		dniList.add(dni9);
		dniList.add(dni10);
		
	}

	

}
