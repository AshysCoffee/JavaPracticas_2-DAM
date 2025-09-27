package pruebas;

import java.util.ArrayList;
import java.util.Scanner;

public class Portal {

	public static void main(String[] args) {
				
	
		ArrayList <Ficha> Personal = new ArrayList <Ficha>();
		
		Ficha p1 = new Profesor ("22222222J", "Jose", "Fernandez Postra", 1165.45, 2, false);
		Ficha p2 = new Profesor ("99999999P", "Sandra", "Martinez Mares", 1954.15, 9, true);

		Ficha a1 = new Administracion ("666666666Z", "Alonso", "Dosa Postra", 1215.45, "Ingeniero Aeroneutico", 1);
		Ficha a2 = new Administracion ("777777777M", "Pedro", "Martinez Lirios", 1002.15, "Coordinador", 6);
		
		Ficha d1 = new Directivo ("333333333N", "Maria", "Fernandez Luna", 1815.05, false, Horario.MANAÑA);
		Ficha d2 = new Directivo ("555555555L", "Laura", "Valencia Mares", 1414.95, true, Horario.TARDE);
		
		
		Personal.add(p1);
		Personal.add(p2);
		Personal.add(a1);
		Personal.add(a2);
		Personal.add(d1);
		Personal.add(d2);
		
		ArrayList <Modulo> Modulos = new ArrayList <Modulo>();
		Modulo m1 = new Modulo ("Biologia", 6, (Profesor) p1, false);
		Modulo m2 = new Modulo ("FOL", 2, (Profesor) p2, true);
		Modulo m3 = new Modulo ("Quimica", 8, (Profesor) p1, false);
		Modulo m4 = new Modulo ("Fisica", 3, (Profesor) p2, false);
		
		
		Modulos.add(m1);
		Modulos.add(m2);
		Modulos.add(m3);
		Modulos.add(m4);
		
		ArrayList <Alumno> Hijos = new ArrayList <Alumno>();
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Bienvenido al portal escolar.\nIndique que desea realizar:\n1. Crear nuevo usuario\n2. Mostrar personal escolar\n"
				+ "3. Mostrar profesorado"
				+ "\n4. Mostrar personal directivo\n5. Desglosar los módulos\n6. Listar hijos escolarizados\n");
		
		int opcion=0;
		opcion=sc.nextInt();
		
		String nombre=" ";
		String apellidos=" ";
		String dni=" ";
		String fecha_nac=" ";
		char sexo=' ';
		char repetidor = ' ';
		
		switch (opcion) {
			case 1:
				
				sc.nextLine();
				
				Alumno h1 = new Alumno (null, null, null, null, null, false);
				System.out.print("Introduzca los siguientes datos:\nNombre: ");
				nombre=sc.nextLine();
				
				System.out.print("Apellidos: ");
				apellidos=sc.nextLine();
				
				System.out.print("DNI: ");
				dni=sc.nextLine();
				
				System.out.print("Fecha de nacimiento (en formato = dd/MM/anno) :");
				fecha_nac=sc.nextLine();
				
				System.out.print("Sexo (F = Femenino, M = Masculino) :");
				sexo=sc.next().charAt(0);
				
				System.out.print("Repetidor (S - Si , N - No:) :");
				repetidor=sc.next().charAt(0);
				
				
				h1.CrearAlumno(dni, nombre, apellidos, fecha_nac, sexo, repetidor);
				
				Hijos.add(h1);
				
				System.out.println("\n\n"+h1.toString());
				
				break;
				
			case 2:
				
				System.out.println("Personal: ");
				
				for (Ficha f:Personal ) {
					if (f instanceof Administracion) {
						System.out.println(f.toString());
					}	
				}

				break;
				
			case 3:
				
				for (Ficha f:Personal ) {
					if (f instanceof Profesor) {
						System.out.println(f.toString());
					}	
				}
				
				break;

			case 4:
				
				for (Ficha f:Personal ) {
					if (f instanceof Directivo) {
						System.out.println(f.toString());
					}	
				}
				
				break;

			case 5:
				
				System.out.println("Módulos: ");
				for (Modulo m:Modulos) {
					System.out.println(m.toString());
				}
				
				
			case 6:
				
				System.out.println("Hijos escolarizados: ");
				for (Alumno h:Hijos) {
					System.out.println(h.toString());
				}
				break;	
				
				
			default:
				sc.close();
				break;
		}

		
		sc.close();
	}

}
