package s302n3;

public class Principal {

	public static void main(String[] args) {
		
		int saleTotal = 0;

		PayGateway payment = new PayGateway(saleTotal);

		payment.generate();

	}

}
