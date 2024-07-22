package app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.AbstractMap.SimpleEntry;

import corte_irlandes.*;

public class Menu {

	static ArrayList<Product> productList = new ArrayList<Product>();

	public static void runMenu(Scanner sc) {
		int option = -1;

		do {
			try {
				option = menuOption(sc);
			} catch (InputMismatchException e) {
				System.out.println("Error en la introducción de datos por teclado. Introduce un número entero. ");
			}
			menuInit(option, sc);
		} while (option != 0);

	}

	public static int menuOption(Scanner sc) {
		int option;

		do {
			System.out.println("Selecciona la acción que quieres realizar: \n" + "1. - Crear un producto \n"
					+ "2. - Listar productos ordenados de menor a mayor precio \n" + "3. - Eliminar producto \n"
					+ "4. - Calcular fecha vencimiento de la garantía \n" + "5. - Aplicar rebajas a productos \n"
					+ "6. - Productos en rebajas \n" + "7. - Consultar stock de un producto \n"
					+ "8. - Aumentar stock de un producto \n" + "9. - Quitar stock de un producto \n"
					+ "0. - Cerrar el programa. ");

			option = sc.nextInt();
			sc.nextLine();

		} while (!((option <= 9) && (option >= 0)));

		return option;
	}

	public static void menuInit(int option, Scanner sc) {

		switch (option) {
		case 1:
			productAdd(sc);
			break;
		case 2:
			ordenarPrecio();
			break;
		case 3:
			eliminarProducto(sc);
			break;
		case 4:
			//warrantyCalculation(sc);
			break;
		case 5:
			//discountApply(sc);
			break;
		case 6:
			saleProductPrint();
			break;
		case 7:
			productStock(sc);
			break;
		case 8:
			addStock(sc);
			break;
		case 9:
			removeStock(sc);
			break;
		case 0:
			break;

		}

	}

	public static void productAdd(Scanner sc) {

		int productOption = productAddOption(sc);

		switch (productOption) {
		case 1:
			clothingAdd(sc);
			break;
		case 2:
			applianceAdd(sc);
			break;
		case 3:
			electronicAdd(sc);
			break;
		case 4:
			beautyAdd(sc);
			break;
		case 0:
			break;
		}

	}

	public static int productAddOption(Scanner sc) {
		int productOption;

		do {
			System.out.println("Indica el tipo de producto que quieres crear: \n" + "1. - Prenda de ropa \n"
					+ "2. - Electrodoméstico \n" + "3. - Componentes electrónicos \n" + "4. - Belleza \n"
					+ "0. - No crear producto");

			productOption = sc.nextInt();
			sc.nextLine();

		} while (!((productOption <= 4) && (productOption >= 0)));

		return productOption;

	}

	public static void clothingAdd(Scanner sc) {

		System.out.print("Introduce la talla: ");
		String size = sc.nextLine();
		System.out.print("Introduce el tipo de tejido: ");
		String fabric = sc.nextLine();
		System.out.print("Introduce el tipo de prenda: ");
		String garment = sc.nextLine();

		productClothingAdd(sc, size, fabric, garment);

	}

	public static void productClothingAdd(Scanner sc, String size, String fabric, String garment) {

		System.out.print("Introduce el nombre: ");
		String name = sc.nextLine();
		System.out.println("Introduce la marca: ");
		String brand = sc.nextLine();
		System.out.print("Introduce el precio: ");
		float price = sc.nextFloat();
		System.out.print("Introduce el stock: ");
		int stock = sc.nextInt();
		System.out.print("Introduce la fecha de compra: ");
		int purchaseDate = sc.nextInt();
		System.out.print("Introduce la cantidad de descuento: ");
		float discount = sc.nextFloat();
		sc.nextLine();

		Clothing clothingAdd = new Clothing(name, brand, price, stock, purchaseDate, discount, size, fabric, garment);
		productList.add(clothingAdd);
		System.out.println("Se ha añadido el producto de ropa correctamente. ");

	}

	public static void applianceAdd(Scanner sc) {

		System.out.print("Introduce el consumo: ");
		float consumption = sc.nextFloat();
		System.out.print("Introduce la fecha de fabricación: ");
		int fabricationDate = sc.nextInt();
		System.out.print("Introduce la capacidad: ");
		int capacity = sc.nextInt();

		productApplianceAdd(sc, consumption, fabricationDate, capacity);

	}

	public static void productApplianceAdd(Scanner sc, float consumption, int fabricationDate, int capacity) {

		System.out.print("Introduce el nombre: ");
		String name = sc.nextLine();
		System.out.println("Introduce la marca: ");
		String brand = sc.nextLine();
		System.out.print("Introduce el precio: ");
		float price = sc.nextFloat();
		System.out.print("Introduce el stock: ");
		int stock = sc.nextInt();
		System.out.print("Introduce la fecha de compra: ");
		int purchaseDate = sc.nextInt();
		System.out.print("Introduce la cantidad de descuento: ");
		float discount = sc.nextFloat();
		sc.nextLine();

		Appliance applianceAdd = new Appliance(name, brand, price, stock, purchaseDate, discount, consumption,
				fabricationDate, capacity);
		productList.add(applianceAdd);
		System.out.println("Se ha añadido el producto electrodoméstico correctamente. ");

	}

	public static void electronicAdd(Scanner sc) {

		System.out.print("Introduce el ancho de la resolución: ");
		int resolution1 = sc.nextInt();
		System.out.print("Introduce el alto de la resolución: ");
		int resolution2 = sc.nextInt();
		SimpleEntry<Integer, Integer> resolution = new SimpleEntry<Integer, Integer>(resolution1, resolution2);
		System.out.print("Introduce la fecha de fabricación: ");
		int batery = sc.nextInt();
		sc.nextLine();

		productElectronicAdd(sc, resolution, batery);

	}

	public static void productElectronicAdd(Scanner sc, SimpleEntry<Integer, Integer> resolution, int batery) {

		System.out.print("Introduce el nombre: ");
		String name = sc.nextLine();
		System.out.println("Introduce la marca: ");
		String brand = sc.nextLine();
		System.out.print("Introduce el precio: ");
		float price = sc.nextFloat();
		System.out.print("Introduce el stock: ");
		int stock = sc.nextInt();
		System.out.print("Introduce la fecha de compra: ");
		int purchaseDate = sc.nextInt();
		System.out.print("Introduce la cantidad de descuento: ");
		float discount = sc.nextFloat();
		sc.nextLine();

		Electronic electronicAdd = new Electronic(name, brand, price, stock, purchaseDate, discount, resolution,
				batery);
		productList.add(electronicAdd);
		System.out.println("Se ha añadido el producto de componentes electrónicos correctamente. ");

	}

	public static void beautyAdd(Scanner sc) {
		int veganOpt;
		boolean vegan = false;
		do {
		System.out.println("Introduce si es vegano): \n"
				+ "1. Es vegano \n"
				+ "2. No es vegano .");
		veganOpt = sc.nextInt();
		} while (!(veganOpt == 1) || (veganOpt == 0));
		
		if (veganOpt == 1) {
			vegan = true;
		}
		
		
		
		System.out.println("Introduce la temporada del producto: ");
		String season = sc.nextLine();
		sc.nextLine();

		productBeautyAdd(sc, vegan, season);

	}
	
	public static void productBeautyAdd(Scanner sc, boolean vegan, String season) {
		
		System.out.print("Introduce el nombre: ");
		String name = sc.nextLine();
		System.out.println("Introduce la marca: ");
		String brand = sc.nextLine();
		System.out.print("Introduce el precio: ");
		float price = sc.nextFloat();
		System.out.print("Introduce el stock: ");
		int stock = sc.nextInt();
		System.out.print("Introduce la fecha de compra: ");
		int purchaseDate = sc.nextInt();
		System.out.print("Introduce la cantidad de descuento: ");
		float discount = sc.nextFloat();
		sc.nextLine();

		Beauty beautyAdd = new Beauty(name, brand, price, stock, purchaseDate, discount, vegan);
		productList.add(beautyAdd);
		System.out.println("Se ha añadido el producto de belleza correctamente. ");
		
	}
	
	public static void ordenarPrecio() {
		
		productList.sort(Comparator.comparing(Product::getPrice));
		productList.forEach(System.out::println);
	}
	
	public static int idInput(Scanner sc) {
		System.out.print("Introduce la ID del producto que quieres buscar: ");
		int idInput = sc.nextInt();
		sc.nextLine();
		
		return idInput;
		
	}
	
	public static void eliminarProducto(Scanner sc) {
		
		int idRemove = idInput(sc);
		sc.nextLine();
		boolean match = false;
		int i = 0;
		
		while (!match && i<productList.size()) {
			if (idRemove == productList.get(i).getIdCode()) {
				match = true;
			} else {
				i++;
			}
		}
		productList.remove(i);
		System.out.println("El producto con ID "+ idRemove +" se ha eliminado correctamente. ");
	}
	
	
	public static void discountApply(Scanner sc) {
		
		//establecer criterio mediante el cual se aplica el descuento (tipo de producto, atributo)
		// Product.applyDiscount();
		
	}
	
	
	public static void saleProductPrint() {
		
		for (Product product : productList) {
			if (product.getDiscount() != 0) {
				System.out.println(product.toString());
			}
		}
	}
	
	
	public static void productStock(Scanner sc) {
		
		int idCheck = idInput(sc);
		sc.nextLine();
		boolean match = false;
		int i = 0;
		
		while (!match && i<productList.size()) {
			if (idCheck == productList.get(i).getIdCode()) {
				match = true;
			} else {
				i++;
			}
		}
		System.out.println("El stock del producto introducido es "+ productList.get(i).getStock());
		
	}
	
	public static void addStock(Scanner sc) {
		int idCheck = idInput(sc);
		int stockInc = 0;
		sc.nextLine();
		boolean match = false;
		int i = 0;
		
		while (!match && i<productList.size()) {
			if (idCheck == productList.get(i).getIdCode()) {
				match = true;
			} else {
				i++;
			}
		}
		System.out.print("Introduce la cantidad del stock que quieres aumentar: ");
		try {
		stockInc = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Error en el tipo de dato introducido. ");
		}
		productList.get(i).setStock(productList.get(i).getStock()+stockInc);
		System.out.println("El stock actual del producto"+ productList.get(i).getIdCode()+" es "+ productList.get(i).getStock()+". ");
	}
	
	public static void removeStock(Scanner sc) {
		int idCheck = idInput(sc);
		int stockInc = 0;
		sc.nextLine();
		boolean match = false;
		int i = 0;
		
		while (!match && i<productList.size()) {
			if (idCheck == productList.get(i).getIdCode()) {
				match = true;
			} else {
				i++;
			}
		}
		System.out.print("Introduce la cantidad del stock que quieres quitar: ");
		try {
		stockInc = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Error en el tipo de dato introducido. ");
		}
		productList.get(i).setStock(productList.get(i).getStock() - stockInc);
		System.out.println("El stock actual del producto"+ productList.get(i).getIdCode()+" es "+ productList.get(i).getStock()+". ");
		
		if(productList.get(i).getStock() <= 0) {
			System.out.println("El stock ha quedado por debajo de 0, es necesario reponer.");
		}
	}
	
	

}
