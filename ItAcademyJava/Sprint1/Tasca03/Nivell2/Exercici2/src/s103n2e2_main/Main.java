package s103n2e2_main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import s103n2e2_gestio.Restaurant;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<Restaurant> restaurantSet = new HashSet<Restaurant>();
		ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
		char start = ' ';
		char finish = ' ';
		
		
		Restaurant restaurant1 = new Restaurant("Bar Na", 8);
		Restaurant restaurant2 = new Restaurant("Bar Na", 7);
		Restaurant restaurant3 = new Restaurant("Bar Na", 6);
		Restaurant restaurant4 = new Restaurant("Bar Na", 5);
		Restaurant restaurant5 = new Restaurant("Bar Na", 4);
		Restaurant restaurant6 = new Restaurant("Bar Na", 8);
		Restaurant restaurant7 = new Restaurant("Bar Na", 6);
		Restaurant restaurant8 = new Restaurant("La Cala", 7);
		Restaurant restaurant9 = new Restaurant("La Cala", 6);
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
		
		System.out.println("Vols introduir un nou restaurant? Introdurïx \'s\' per començar.  ");
		start = sc.nextLine().charAt(0);
		
		while (finish != 'n' && start == 's'){
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

		}
		
		for (Restaurant restaurantToList : restaurantSet) {
			restaurantList.add(restaurantToList);
		}
		
		
		restaurantList.sort(Comparator.comparing(Restaurant::getNom).thenComparing(Restaurant::getPuntuacio));
		System.out.println(restaurantList.toString());
		sc.close();

	}


}
