package ejercicios;

import java.util.Scanner;

public class DNIe {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca su DNI: ");
		String dni = sc.next();
		
		boolean malFormato = false;
		do {
			
			if (dni.length() < 8) {
				System.err.println("ERROR: Su DNIe es menor a 8 caracteres, pruebe de nuevo: ");
				malFormato = true;
				System.out.println("\n Introduzca su DNIe: ");
				dni = sc.next();
			} else {
				malFormato = false;
			}
			
		} while (malFormato);
		
		char[] letrasArray = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
				'H', 'L', 'C', 'K', 'E' };
		int dniNumerico =(int) (Long.valueOf(dni) % 23);
		System.out.println("La letra que le corresponde a su DNIe es: " + letrasArray[dniNumerico]);
		System.out.println("Su DNI es: "+dni+letrasArray[dniNumerico]);
		sc.close();
		
	}
	
}

