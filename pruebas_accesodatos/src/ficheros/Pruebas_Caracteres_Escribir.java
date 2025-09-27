package ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Pruebas_Caracteres_Escribir {

	public static void main(String[] args) {

		BufferedWriter fichero = null;
		try {
			fichero = new BufferedWriter(new FileWriter("Fichero_Ejercicio2.txt"));
			String cad = "Escribe un fichero de caracteres desde tu programa java"; //primera línea
			
			fichero.write(cad);
			
			cad= ", linea a linea."; //segunda linea
			fichero.newLine();
			fichero.write(cad); 
			
			cad= "Ejercicio 2"; //tercera linea
			fichero.newLine();
			fichero.write(cad);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (fichero != null) { //este bloque de codigo tiene que incluido para que escriba.
				try {
					fichero.close(); //hacemos que se vacíe el búfer y se escriba en el archivo
				} catch (IOException ex) {
					System.out.println(ex);
	
				}
			}

		}
		
	}
}

/* OTRA FORMA ES: MAS FACTORIZADO Y SENCILLA :3
 * 
 * try {
 * 
 * 	FileReader lector = new FileReader (fichero);
 * 		BUfferedReader bffer = new BufferedReader(lector);
 * 		String linea;
 * 
 * 	while ((linea=buffer.readLine())!=null){
 *  		syso (linea);* 
 * }
 * 
 * 
 * } catch{
 * 			lol e.getMessage;
 * 
 * }	*/
 