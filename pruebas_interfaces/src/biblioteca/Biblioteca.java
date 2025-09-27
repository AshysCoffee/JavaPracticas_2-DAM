package biblioteca;

import java.util.ArrayList;

public class Biblioteca {

	private static ArrayList <Libro> Libros = new ArrayList<> ();
	private static ArrayList <Revista> Revistas = new ArrayList<> ();
	
	public static void main(String[] args) {
		
		Libro l1 = new Libro ("Los 3 cerditos", "987654321", "2014");
		Libro l2 = new Libro ("Caperucita", "1112222333", "2021");
		Libro l3 = new Libro ("El Principito", "5556644852", "2008");
		
		Revista r1 = new Revista ("Hola", "994442111", "2025", 55);
		Revista r2 = new Revista ("De Corazon", "333311111777", "2022", 12);
		Revista r3 = new Revista ("Lecturas", "666522444", "2023", 65);
	
		Libros.add(l1);
		Libros.add(l2);
		Libros.add(l3);
		
		Revistas.add(r1);
		Revistas.add(r2);
		Revistas.add(r3);
		
		l1.prestar();
		System.out.println(l1.prestado());
		
		l1.devolver();
		System.out.println(l1.prestado());
		
		for (Libro l:Libros) {
			System.out.println(l.toString());
		}
		
		System.out.println("\n\n");
		
		for (Revista r:Revistas) {
			System.out.println(r.toString());
		}
		
		
	}

}
