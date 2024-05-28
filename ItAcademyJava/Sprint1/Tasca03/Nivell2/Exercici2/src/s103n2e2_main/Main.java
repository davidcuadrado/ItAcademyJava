package s103n2e1_main;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import s103n2e1_gestio.Restaurant;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Restaurant> restaurantSet = new HashSet<Restaurant>();
		char finish = ' ';
		
		/* Set de proves
		Restaurant restaurant1 = new Restaurant("Bar Na", 8);
		Restaurant restaurant2 = new Restaurant("Bar Na", 7);
		Restaurant restaurant3 = new Restaurant("Bar Na", 6);
		Restaurant restaurant4 = new Restaurant("Bar Na", 5);
		Restaurant restaurant5 = new Restaurant("Bar Na", 4);
		Restaurant restaurant6 = new Restaurant("Bar Na", 8);
		Restaurant restaurant7 = new Restaurant("Bar Na", 6);
		Restaurant restaurant8 = new Restaurant("Bar Man", 7);
		Restaurant restaurant9 = new Restaurant("Bar Man", 6);
		restaurantSet.add(restaurant2);
		restaurantSet.add(restaurant3);
		restaurantSet.add(restaurant4);
		restaurantSet.add(restaurant5);
		restaurantSet.add(restaurant6);
		restaurantSet.add(restaurant7);
		restaurantSet.add(restaurant8);
		restaurantSet.add(restaurant9);
		restaurantSet.add(restaurant1);
		
		System.out.println(restaurantSet.toString());
		*/

		
		do {
			try {
			System.out.print("Introdueïx el nom: ");
			String nom = sc.nextLine();
			System.out.print("Introdueïx la puntuació: ");
			int puntuacio = sc.nextInt();
			sc.nextLine();
			Restaurant restaurantAdd = new Restaurant(nom, puntuacio);
			restaurantSet.add(restaurantAdd);
			System.out.println("Vols afegir un altre restaurant? Introdueïx \'n\' per finalitzar. ");
			finish = sc.nextLine().charAt(0);
			} catch (InputMismatchException e) {
				System.out.println("Error en la introducció de dades. ");
			}

		} while (finish != 'n');
		System.out.println(restaurantSet.toString());

	}


}
