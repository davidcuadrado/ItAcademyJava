package s101n1e2;

public class S101N1E2_main {

	public static void main(String[] args) {
		
		Cotxe cotxeAdd = new Cotxe((short) 65);
		System.out.println(cotxeAdd.toString());
		Cotxe.setModel("Polo");
		System.out.println(cotxeAdd.toString());
		
		Cotxe.frenar();
		cotxeAdd.accelerar();

	}

}
