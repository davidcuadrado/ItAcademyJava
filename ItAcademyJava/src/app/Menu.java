package app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	
	public static void runMenu(Scanner sc) {
		int option = -1;
		
		do {
			try {
		option = menuOption(sc);
			} catch (InputMismatchException e) {
				System.out.println("Error en la introducción de datos por teclado. Introduce un número entero. ");
			}
		menuInit(option);
		} while (option != 0);
		
		
	}
	
	
	public static int menuOption(Scanner sc) {
		int option;
		
		do {
		System.out.println("Selecciona la acción que quieres realizar: \n"
				+ "1. - Crear un producto \n"
				+ "2. - Listar productos ordenados de menor a mayor precio \n"
				+ "3. - Eliminar producto \n"
				+ "4. - Calcular fecha vencimiento de la garantía \n"
				+ "5. - Aplicar rebajas a productos \n"
				+ "6. - Productos en rebajas \n"
				+ "7. - Consultar stock de un producto \n"
				+ "8. - Aumentar stock de un producto \n"
				+ "9. - Quitar stock de un producto \n"
				+ "0. - Cerrar el programa. ");
		
		option = sc.nextInt();
		sc.nextLine();
		
		} while (!((option <= 9) && (option >= 0)));
		
		
		return option;
	}
	
	public static void menuInit(int option) {
		
		switch (option) {
		case 1:
			productAdd();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 0:
			break;
			
		}
		
		
	}
	
	public static void productAdd(Scanner sc) {
		
		int productOption = productAddOption(sc);
		
		switch (productOption) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 0:
			break;
		}
		
	}
	
	public static int productAddOption(Scanner sc) {
		int productOption;
		
		do {
		System.out.println("Indica el tipo de producto que quieres crear: \n"
				+ "1. - Prenda de ropa \n"
				+ "2. - Electrodoméstico \n"
				+ "3. - Componentes electrónicos \n"
				+ "4. - Belleza \n"
				+ "0. - No crear producto" );
		
		productOption = sc.nextInt();
		sc.nextLine();
		
		} while (!((productOption <= 4) && (productOption >= 0)));
		
		
		return productOption;
		
	}
	
	
	
	

}
