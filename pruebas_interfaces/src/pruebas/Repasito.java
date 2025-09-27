package pruebas;

import java.util.Scanner;

public class Repasito {
	
	 public static long factorial(int n) {
	        if (n == 0 || n == 1) {
	            return 1; // caso base
	        } else {
	            return n * factorial(n - 1); // llamada recursiva
	        }
	    }

	public static void main(String[] args) {
		
		
		/*Crear un programa sencillo en el que se creen
		variables de tipo String, int, char, double, boolean. Asociarles un
		valor e imprimirlo por pantalla.*/
		
	String valor1 = "Hola World";
	int num1 = 1;
	char vocal = 'a';
	double con_coma= 2.99;
	boolean verdad = true;
	
	System.out.println(valor1);
	System.out.println(num1);
	System.out.println(vocal);
	System.out.println(con_coma);
	System.out.println(verdad+"\n\n");
	
	
	/*A partir de un array de enteros, recorrerlo y obtener por pantalla la cantidad total de números pares.*/
	
	int[] array = {1,2,3,4,5,6,7,8,9,10};
	int contador = 0;
	
	for(int i = 0; i<10; i++) {
		if (array[i]%2==0) {
			contador++;
		}
	}	
	
	System.out.println(contador);
	
	
	/*Crear una matriz de enteros de n x n (tamaño lo decide el usuario), rellenar con números aleatorios, recorrerla y dar la suma de todos sus números.*/

	Scanner sc = new Scanner(System.in);
	
	int[][] matriz = new int [3][3];
	
	int sumatorio = 0;
	
	for (int i=0; i<3; i++) {
		for (int j=0; j<3; j++) {
			matriz [i][j]=sc.nextInt();
		}
		
	}

	for (int i=0; i<3; i++) {
		System.out.print("[");
		for (int j=0; j<3; j++) {
			System.out.print(+matriz[i][j]+" ");
		}
		System.out.println("]");
	}

	
	for (int i=0; i<3; i++) {
		for (int j=0; j<3; j++) {
			sumatorio+=matriz[i][j];
		}
		
	}
	System.out.println(sumatorio);
	
	
	/*Calcular el factorial de un número entero positivo a través de la recursividad.*/
		
	
	int n = sc.nextInt();

	if (n < 0) {
		System.out.println("El número debe ser positivo.");
	} else {
		long resultado = factorial(n);
		System.out.println("El factorial de " + n + " es: " + resultado);
	}

	sc.close();


	}

}
