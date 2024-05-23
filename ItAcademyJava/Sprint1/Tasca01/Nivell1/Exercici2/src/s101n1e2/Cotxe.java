package s101n1e2;

public class Cotxe {
	
	private static final String marca = "Volkswagen";
	private static String model;
	private final short potencia;
	
	
	public Cotxe(short potencia) {
		this.potencia = potencia;
	}


	public static String getModel() {
		return model;
	}


	public static void setModel(String model) {
		Cotxe.model = model;
	}


	public static String getMarca() {
		return marca;
	}


	public short getPotencia() {
		return potencia;
	}
	
	public static void frenar() {
		System.out.println("El vehicle està frenant. ");
	}
	
	public void accelerar() {
		System.out.println("El vehicle està accelerant. ");
	}
	


	@Override
	public String toString() {
		return "Cotxe [marca ="+ marca + ", model =" + model + ", potencia=" + potencia + "]";
	}
	
	
	
	
	

}
