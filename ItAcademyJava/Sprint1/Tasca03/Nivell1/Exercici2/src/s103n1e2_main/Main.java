package s103n1e2_main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		List<Integer> lista1 = new ArrayList<Integer>();
		lista1AddNumbers(lista1);
		System.out.print("Lista 1: \n"+lista1);
		List<Integer> lista2 = new ArrayList<Integer>();
		lista2AddInvLista1(lista1, lista2);
		System.out.print("Lista 2: \n"+lista2);
		

	}
	
	public static void lista1AddNumbers(List<Integer>lista1){
		
		for (int i = 0; i < 5; i++) {
			lista1.add(i);
		}
	}
	
	public static void lista2AddInvLista1(List<Integer>lista1, List<Integer>lista2) {
		ListIterator<Integer> li = lista1.listIterator();
		while(li.hasNext()) {
			lista2.add(li.next());
		}
		Collections.reverse(lista2);
	}

}
