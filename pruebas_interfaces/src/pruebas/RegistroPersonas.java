package pruebas;

import java.util.ArrayList;

public class RegistroPersonas {

	public static void main(String[] args) {
		
		ArrayList <Ficha> Personal = new ArrayList <Ficha>();
		
		Ficha p1 = new Profesor ("22222222J", "Jose", "Fernandez Postra", 1165.45, 2, false);
		Ficha p2 = new Profesor ("99999999P", "Sandra", "Martinez Mares", 1954.15, 2, true);
		Ficha p3 = new Profesor ("22222222J", "Pablo", "Garcia Pan", 1006.96, 2, false);
		Ficha p4 = new Profesor ("99999999P", "Marta", "Mendez Mares", 1361.84, 1, true);

		Ficha a1 = new Administracion ("666666666Z", "Alonso", "Dosa Postra", 1215.45, "Ingeniero Aeroneutico", 1);
		Ficha a2 = new Administracion ("777777777M", "Pedro", "Martinez Lirios", 1002.15, "Coordinador", 6);
		
		Ficha d1 = new Directivo ("333333333N", "Maria", "Fernandez Luna", 1815.05, false, Horario.MANAÑA);
		Ficha d2 = new Directivo ("555555555L", "Laura", "Valencia Mares", 1414.95, true, Horario.TARDE);
		
		
		Personal.add(p1);
		Personal.add(p2);
		Personal.add(p3);
		Personal.add(p4);
		Personal.add(a1);
		Personal.add(a2);
		Personal.add(d1);
		Personal.add(d2);
		
		/*System.out.println("Personal: ");
		for (Ficha f:Personal) {
			System.out.println(f.toString());
		}*/
		
		Personal.sort(null);

		System.out.println("Personal: (Ordenados de menor a mayor ");
		for (Ficha f:Personal) {
			System.out.println(f.toString());
		}
		
		/*
		
		
		ArrayList <Modulo> Modulos = new ArrayList <Modulo>();
		Modulo m1 = new Modulo ("Biologia", 6, (Profesor) p1, false);
		Modulo m2 = new Modulo ("FOL", 2, (Profesor) p2, true);
		Modulo m3 = new Modulo ("Quimica", 8, (Profesor) p1, false);
		Modulo m4 = new Modulo ("Fisica", 3, (Profesor) p2, false);
		
		
		Modulos.add(m1);
		Modulos.add(m2);
		Modulos.add(m3);
		Modulos.add(m4);
		
		
		System.out.println("Módulos: ");
		for (Modulo m:Modulos) {
			System.out.println(m);
		}
		
		
		Alumno n1 = new Alumno ("111111111R","Angelo", "Mendez Lorca", "14/05/2004" , Sexo.MASCULINO, true);
		Alumno n2 = new Alumno ("444444444V","Manuel", "Perez Paniagua", "29/12/2001" , Sexo.MASCULINO, true);
		
		
		
		n1.ModuloAdd(m2);
		n1.ModuloAdd(m3);
		
		n2.ModuloAdd(m1);
		n2.ModuloAdd(m4);
		
		
		System.out.println(n1.toString());
		System.out.println(n1.getModulos().toString());
		
		System.out.println(n2.toString());
		System.out.println(n2.getModulos().toString());*/
		
	}

}
