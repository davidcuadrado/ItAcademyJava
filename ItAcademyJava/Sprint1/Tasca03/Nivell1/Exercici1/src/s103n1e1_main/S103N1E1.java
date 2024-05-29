package s103n1e1_main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import s103n1e1.*;

public class S103N1E1 {

	public static void main(String[] args) {
		ArrayList<Month> monthList = new ArrayList<Month>();
		
		monthAddArrayList(monthList);
		printMonthArrayList(monthList);
		augustAddArrayList(monthList);
		printMonthArrayList(monthList);
		
		HashSet<Month> monthHashSet = new HashSet<Month>();
		monthHashSet.addAll(monthList);
		
		printMonthHashSet(monthHashSet);
		monthHashSetAddAndRepeat(monthList, monthHashSet);
		printMonthHashSet(monthHashSet);
		
	}
	
	public static void monthAddArrayList(ArrayList<Month> monthList) {
		Month month1 = new Month("Gener");
		Month month2 = new Month("Febrer");
		Month month3 = new Month("Març");
		Month month4 = new Month("Abril");
		Month month5 = new Month("Maig");
		Month month6 = new Month("Juny");
		Month month7 = new Month("Juliol");
		Month month9 = new Month("Setembre");
		Month month10 = new Month("Octubre");
		Month month11 = new Month("Novembre");
		Month month12 = new Month("Desembre");
		
		monthList.add(month1);
		monthList.add(month2);
		monthList.add(month3);
		monthList.add(month4);
		monthList.add(month5);
		monthList.add(month6);
		monthList.add(month7);
		monthList.add(month9);
		monthList.add(month10);
		monthList.add(month11);
		monthList.add(month12);
		
		System.out.println("** 11 objectes Month afegits a l'ArrayList ** ");
	}
	
	public static void augustAddArrayList(ArrayList<Month> monthList) {
		
		Month month8 = new Month("Agost");
		monthList.add(7, month8);
		System.out.println("\n\n** Month Agost afegit a la seva posició correcta ** ");
	}
	
	public static void printMonthArrayList(ArrayList<Month> monthList) {
		System.out.println("\nMonths ArrayList (ArrayList recorrido con bucle for): ");
		for (int i = 0; i<monthList.size(); i++) {
			System.out.println(monthList.get(i).toString());
		}
		System.out.println("\nMonths ArrayList (ArrayList recorrido con iterator): ");
		Iterator<Month> it = monthList.iterator();
		
		while(it.hasNext()) {
		System.out.println(it.next());
		}
	}
	
	
	public static void monthHashSetAddAndRepeat(ArrayList<Month> monthList, HashSet<Month> monthHashSet) {
		for (Month month : monthList) {
			monthHashSet.add(month);
		}
		Month monthX = new Month("X X X X X X ");
		monthHashSet.add(monthX);
		System.out.println("\n** Proba de duplicats HashSet realitzada ** ");
	}
	
	
	public static void printMonthHashSet(HashSet<Month> monthHashSet) {
		System.out.println("\nMonths HashSet: ");
		
		for(Month month : monthHashSet) {
			System.out.println(month);
		}
	}

}
