package ejercicios_lect_escrit;

public class Pruebas_COdigo {

	public static void main(String[] args) {
		
		 for (int numero = 2; numero <= 500; numero++) {
             int divisores = 0;

             // Contamos cuántos divisores tiene "numero"
             for (int divisor = 1; divisor <= numero; divisor++) {
                 if (numero % divisor == 0) {
                     divisores++;
                 }
             }

             // Si tiene solo 2 divisores → es primo
             if (divisores == 2) {
                 System.out.println(numero);   // mostramos en pantalla
               
             }
         }

	}

}
