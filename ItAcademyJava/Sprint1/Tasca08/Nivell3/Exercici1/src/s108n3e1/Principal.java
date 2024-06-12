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
		alumneList.add(new Alumne("Pere", 25, Curso.JAVA, 8));
		alumneList.add(new Alumne("Maria", 21,Curso.PHP, 9));
		alumneList.add(new Alumne("Paula", 35, Curso.ANGULAR, 7));
		alumneList.add(new Alumne("Ferran", 17, Curso.REACT, 5));
		alumneList.add(new Alumne("Josep", 30, Curso.JAVA, 4));
		alumneList.add(new Alumne("Laura", 23, Curso.JAVA, 6));
		alumneList.add(new Alumne("Jonathan", 28, Curso.PHP, 6));
		alumneList.add(new Alumne("Martí", 22, Curso.JAVA, 3));
		alumneList.add(new Alumne("Andrea", 32, Curso.JAVA, 8));
		alumneList.add(new Alumne("Berta", 16, Curso.JAVA, 9));
	}

	public static void mostrarNomEdat(List<Alumne> alumneList) {

		System.out.println("_ _ _ _ _ _\nApartado 1: \n");
		alumneList.forEach(n -> System.out.println("NOM: " + n.getNom() + ",	EDAT: " + n.getEdat()));
	}

	public static void filtrarLletraA(List<Alumne> alumneList) {
		Predicate<Alumne> començaAmbA = n -> n.getNom().toLowerCase().charAt(0) == 'a';

		alumneList = alumneList.stream().filter(començaAmbA).toList();
		System.out.println("_ _ _ _ _ _\nApartado 2: \n");
		alumneList.forEach(n -> System.out.println(n.toString()));
	}

	public static void filtrarNota5IMes(List<Alumne> alumneList) {
		Predicate<Alumne> aprobat = n -> n.getNota() >= 5;

		alumneList = alumneList.stream().filter(aprobat).toList();
		System.out.println("_ _ _ _ _ _\nApartado 3: \n");
		alumneList.forEach(System.out::println);
	}

	public static void filtrarNota5IMesNoPHP(List<Alumne> alumneList) {
		Predicate<Alumne> nota5Mes = n -> n.getNota() >= 5;
		Predicate<Alumne> noEsPHP = n -> n.getCurs() != Curso.PHP;

		alumneList = alumneList.stream().filter(nota5Mes.and(noEsPHP)).toList();
		System.out.println("_ _ _ _ _ _\nApartado 4: \n");
		alumneList.forEach(System.out::println);
	}

	public static void filtrarJavaAdults(List<Alumne> alumneList) {
		Predicate<Alumne> majorEdat = alum -> alum.getEdat() >= 18;
		Predicate<Alumne> esJava = alum -> alum.getCurs() == Curso.JAVA;
		
		alumneList = alumneList.stream().filter(esJava.and(majorEdat)).toList();
		System.out.println("_ _ _ _ _ _\nApartado 5: \n");
		alumneList.forEach(System.out::println);
	}

}
