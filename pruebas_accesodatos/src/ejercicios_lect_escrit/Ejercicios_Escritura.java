package ejercicios_lect_escrit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class Ejercicios_Escritura {
	
	public static void main(String[] args) {
		

		
		/*File f = new File ("primos.txt");


// añade el metodoo de comprobar el archivo osea si no existe se crea  


		try {
			BufferedWriter buffer_w = new BufferedWriter (new FileWriter(f)); //al tener true, lo que se imprime una vez se deja y se vuelve a imprimir
			//abre buffer


			for (int numero = 2; numero <= 500; numero++) {
				int divisores=0;
				
				for (int divisor = 1; divisor <= numero; divisor++) {
					if (numero % divisor == 0) {
						divisores++;
					}
				}

				if (divisores == 2) {
					buffer_w.write(String.valueOf(numero));
					buffer_w.newLine();
				}

			}

			buffer_w.close();

		} catch (IOException e) {
			e.getMessage();


		}	*/

//------------------------------------------------------------------------------
		
		
		/*File f = new File ("registroDeUsuario.txt");
		
		Scanner sc = new Scanner (System.in);
		
		try {
			BufferedWriter buffer_w = new BufferedWriter(new FileWriter(f));
			
			String linea = " ";
			String texto = " ";
			
			while (linea!=null && !linea.equalsIgnoreCase("fin")) {
			
			linea=sc.next();
			texto=linea;
			if (!linea.equalsIgnoreCase("fin")) {
			buffer_w.write(texto);
			buffer_w.newLine();
			}else{
				buffer_w.write("");
			}
		}	
			sc.close();
			buffer_w.close();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		*/
		
//---------------------------------------------------------------------------------
		
		
		/*Scanner sc = new Scanner (System.in);
		String ruta = " ";
		
		
		System.out.println("Por favor escriba la ruta del archivo en el cual quiere guardar la serie de numeros:");
		
		ruta=sc.next();
		
		File f = new File (ruta);
		
		System.out.println("Introduzca los numeros de uno en uno y escriba 0 para cerrar la lista.");

		try {
			BufferedWriter buffer_w = new BufferedWriter(new FileWriter(f));
			
			String linea = " ";
			String texto = " ";
			
			while (linea!=null && !linea.equalsIgnoreCase("0")) {
			
			linea=sc.next();
			texto=linea;
			if (!linea.equalsIgnoreCase("0")) {
			buffer_w.write(texto);
			buffer_w.newLine();
			}else{
				buffer_w.write("");
			}
		}	
			sc.close();
			buffer_w.close();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}*/
		
		
//---------------------------------------------------------------------------------
		
		/*

4.	Crea una aplicación que pida la ruta de dos ficheros de texto y de una ruta de destino (solo la ruta, sin fichero al final). 
Debes copiar el contenido de los dos ficheros en uno, este tendrá el nombre de los dos ficheros separados por un guion bajo
		 */
		
		
		Scanner sc = new Scanner (System.in);
		
		String ruta1 = " ";
		String ruta2 = " ";
		String ruta_final = " ";
		
		
		System.out.println("Por favor escriba la ruta del primer archivo:");
		ruta1=sc.next();
		
		System.out.println("Por favor escriba la ruta del segundo archivo:");
		ruta2=sc.next();
		
		System.out.println("Por favor escriba la ruta final:");
		ruta_final = sc.next();
		
		File f1 = new File (ruta1);
		File f2 = new File (ruta2);

		

		try {
			
			FileReader lector1 = new FileReader (f1);
			BufferedReader buffer_r1 = new BufferedReader(lector1);
			
			FileReader lector2 = new FileReader (f2);
			BufferedReader buffer_r2 = new BufferedReader(lector2);
			
			
			String nombreFinal = f1.getName() + "_" + f2.getName(); //uno nombres
		    File archivoFinal = new File(ruta_final, nombreFinal); //hago el archivo
		    
		    
		    FileWriter lector_final= new FileWriter (archivoFinal); // creamos el lector
		    BufferedWriter buffer_w_final = new BufferedWriter(lector_final); //creamos escritor
		    
			String linea = " ";
			String texto = " ";
			
			
			while ((linea=buffer_r1.readLine())!=null){
				texto=linea;
				buffer_w_final.write(texto);
				buffer_w_final.newLine();
	          
			}
			
			buffer_r1.close();
			
			
			
			while ((linea=buffer_r2.readLine())!=null){
				texto=linea;
				buffer_w_final.write(texto);
				buffer_w_final.newLine();
	          
			}
			
			buffer_r2.close();
				
			
			buffer_w_final.close();

			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	
	
	}
	
}

