package s104n1e1;

import java.util.ArrayList;

public class Gestion {
	
	/*
	public static void main(String[] args) {
		monthListGen();
	}
	*/

	public ArrayList<Month> monthListGen() {
		ArrayList<Month> monthList = new ArrayList<Month>();

		Month gener = new Month("gener");
		Month febrer = new Month("febrer");
		Month març = new Month("març");
		Month abril = new Month("abril");
		Month maig = new Month("maig");
		Month juny = new Month("juny");
		Month juliol = new Month("juliol");
		Month agost = new Month("agost");
		Month setembre = new Month("setembre");
		Month octubre = new Month("octubre");
		Month novembre = new Month("novembre");
		Month desembre = new Month("desembre");

		monthList.add(gener);
		monthList.add(febrer);
		monthList.add(març);
		monthList.add(abril);
		monthList.add(maig);
		monthList.add(juny);
		monthList.add(juliol);
		monthList.add(agost);
		monthList.add(setembre);
		monthList.add(octubre);
		monthList.add(novembre);
		monthList.add(desembre);
		
		return monthList;

	}
	

}