package s108n3e1;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {

		List<Alumne> alumneList = new ArrayList<Alumne>();
		alumneGenerateAndAddToList(alumneList);

		mostrarNomEdat(alumneList);
		filtrarLletraA(alumneList);
		filtrarNota5IMes(alumneList);
		filtrarNota5IMesNoPHP(alumneList);
		filtrarJavaAdults(alumneList);

	}

	public static void alumneGenerateAndAddToList(List<Alumne> alumneList) {
		alumneList.add(new Alumne("Pere", 25, "Java", 8));
		alumneList.add(new Alumne("Maria", 21, "PHP", 9));
		alumneList.add(new Alumne("Paula", 35, "Angular", 7));
		alumneList.add(new Alumne("Ferran", 17, "React", 5));
		alumneList.add(new Alumne("Josep", 30, "Java", 4));
		alumneList.add(new Alumne("Laura", 23, "Java", 6));
		alumneList.add(new Alumne("Jonathan", 28, "PHP", 6));
		alumneList.add(new Alumne("Martí", 22, "Java", 3));
		alumneList.add(new Alumne("Andrea", 32, "Java", 8));
		alumneList.add(new Alumne("Berta", 16, "Java", 9));
	}

	public static void mostrarNomEdat(List<Alumne> alumneList) {

		System.out.println("_ _ _ _ _ _\nApartado 1: \n");
		alumneList.forEach(n -> System.out.println("NOM: " + n.getNom() + ",	EDAT: " + n.getEdat()));
	}

	public static void filtrarLletraA(List<Alumne> alumneList) {

		alumneList = alumneList.stream().filter(n -> n.getNom().charAt(0) == 'A' || n.getNom().charAt(0) == 'a')
				.toList();
		System.out.println("_ _ _ _ _ _\nApartado 2: \n");
		alumneList.forEach(n -> System.out.println(n.toString()));
	}

	public static void filtrarNota5IMes(List<Alumne> alumneList) {

		alumneList = alumneList.stream().filter(n -> n.getNota() >= 5).toList();
		System.out.println("_ _ _ _ _ _\nApartado 3: \n");
		alumneList.forEach(System.out::println);
	}

	public static void filtrarNota5IMesNoPHP(List<Alumne> alumneList) {

		alumneList = alumneList.stream().filter(n -> n.getNota() >= 5).filter(n -> n.getCurs() != "PHP").toList();
		System.out.println("_ _ _ _ _ _\nApartado 4: \n");
		alumneList.forEach(System.out::println);
	}

	public static void filtrarJavaAdults(List<Alumne> alumneList) {
		
		alumneList = alumneList.stream().filter(n -> n.getCurs() == "Java").filter(n -> n.getEdat() >= 18).toList();
		System.out.println("_ _ _ _ _ _\nApartado 5: \n");
		alumneList.forEach(System.out::println);
	}

}
