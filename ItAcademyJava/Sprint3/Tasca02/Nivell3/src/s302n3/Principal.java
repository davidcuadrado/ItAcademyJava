package s302n3;

import sales.Sale;
import sales.SaleGenerator;

public class Principal {

	public static void main(String[] args) {

		SaleGenerator saleGen1 = new SaleGenerator();
		Sale sale1 = saleGen1.generateSale();

		int saleTotal = sale1.saleTotalCalc();

		PayGateway payment = new PayGateway(saleTotal);

		payment.generate();

	}

}
