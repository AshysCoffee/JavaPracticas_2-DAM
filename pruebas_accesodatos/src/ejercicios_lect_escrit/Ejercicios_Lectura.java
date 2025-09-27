package ejercicios_lect_escrit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Ejercicios_Lectura {

	public static void main(String[] args) {
		
		// File f = new File ("D:\\Docs_Interesantes\\pikachu.txt");
		
	/*	if (!f.exists()) { //primero verificar el fichero lol
			try {
				f.createNewFile(); //si no existe se crea
			} catch (IOException e) {
				e.getMessage();
			}
			
		}else{

			try {

				FileReader lector = new FileReader (f);
				BufferedReader buffer_r = new BufferedReader(lector);
				String linea;
				String sin_espacio;

				while ((linea=buffer_r.readLine())!=null){
					sin_espacio=linea.replaceAll(" ", "");
					System.out.println(sin_espacio);
					
				}

				buffer_r.close();

			} catch (IOException e) {
				e.getMessage();
			}
		}
		*/
		
//------------------------------------------------------------------------------------------------------------------------		
		
		/*if (!f.exists()) { //primero verificar el fichero lol
			try {
				f.createNewFile(); //si no existe se crea
			} catch (IOException e) {
				e.getMessage();
			}

		}else{

			try {

				FileReader lector = new FileReader (f);
				BufferedReader buffer_r = new BufferedReader(lector);
				String linea;
				int contador=0;

				while ((linea=buffer_r.readLine())!=null){
					char[] linea_array = linea.toCharArray();
					for (int i=0; i<linea_array.length;i++) {
						if (linea_array[i]=='a'||linea_array[i]=='e'||linea_array[i]=='o'||linea_array[i]=='u'||linea_array[i]=='i') {
							contador++;
						}
					}

					System.out.println(linea);
				}


				buffer_r.close();

				System.out.println(f.length()); 
				System.out.println(contador);


			} catch (IOException e) {
				e.getMessage();
			}
			
			}*/
		
		
/*2.Crea un programa que según lo que hemos visto hoy lea un fichero y saque por pantalla el número de caracteres que tiene el fichero y el número de vocales.
3.	Dado el fichero restaurantes muestra el fichero de la siguiente forma campo:valor
4.	Escribe un programa que marque las veces que se repite cada palabra del fichero frutas.txt
5.	Crea un fichero que sea capaz de ordenar alfabéticamente las palabras que aparecen el fichero planetas.txt
		 */
		
		
//------------------------------------------------------------------------------------------------------------------------		
		
		
		/*File f = new File ("D:\\Docs_Interesantes\\Restaurants.csv");
		
		
		if (f.exists()) { 
			try {

				FileReader lector = new FileReader (f);
				BufferedReader buffer_r = new BufferedReader(lector);
				String linea;
				String [] palabras_separadas = null;
				
				String [] restaurantes = new String [21];
				String [] direccion = new String [21];
				String [] ciudad = new String [21];
				String [] estado = new String [21];
				String [] cod_postal = new String [21];


				int contador = 0;

				while ((linea=buffer_r.readLine())!=null){
					palabras_separadas=linea.split(",");

					if (palabras_separadas.length == 5) { // seguridad por si alguna línea viene incompleta
						restaurantes[contador]= palabras_separadas[0];
						direccion[contador]= palabras_separadas[1];
						ciudad[contador]= palabras_separadas[2];
						estado[contador]= palabras_separadas[3];
						cod_postal[contador]= palabras_separadas[4];
						contador++;
					}
				}


				buffer_r.close();
				
				  for (int i = 1; i < contador; i++) {
			            System.out.println("Restaurante: " + restaurantes[i] +"\nDirección: " + direccion[i] +"\nCiudad: " + ciudad[i] +
			                               "\nEstado: " + estado[i] +"\nCP: " + cod_postal[i]+"\n\n");
			        }

			} catch (IOException e) {
				e.getMessage();
			}
		}

		*/
	
//------------------------------------------------------------------------------------------------------------------------		
		
		File f = new File ("D:\\Docs_Interesantes\\frutas.txt");
		
		
		try {

			FileReader lector = new FileReader (f);
			BufferedReader buffer_r = new BufferedReader(lector);
			String linea;
			String [] palabras = new String[15];
			
			int contador_palabras=0;

			while ((linea=buffer_r.readLine())!=null && contador_palabras < palabras.length){
				System.out.println(linea);
	            palabras[contador_palabras] = linea;
	            contador_palabras++;
			}

			buffer_r.close();

			
			String [] aux = Arrays.copyOf(palabras,palabras.length);
			
			System.out.println(" ");

		
			for (int i = 0; i<15; i++) {
				while(palabras[i]!=null){
				int contador = 0;
				for (int j = 14 ; j>-1; j--) {
					if (aux[j].equals(palabras[i])){
						contador++;

					}
					
				}
				for (int k = i+1; k < contador_palabras; k++) {
					if (palabras[i].equals(palabras[k])) {
						palabras[k] = null; // marcar como contada
					}
				}
				System.out.println(palabras[i]+" : "+contador);
			}

		}	
			
			
		} catch (IOException e) {
			e.getMessage();
		}
		
	
		
//------------------------------------------------------------------------------------------------------------------------				
		
	/*	File f = new File ("D:\\Docs_Interesantes\\planetas.txt");
		
		try {

			FileReader lector = new FileReader (f);
			BufferedReader buffer_r = new BufferedReader(lector);
			String linea;
			
			int contador=0;
			String [] planetas = new String[15];

			while ((linea=buffer_r.readLine())!=null && contador< planetas.length){
				 planetas[contador] = linea;
				 contador++;
			}

			buffer_r.close();
			
			String[] leidos=Arrays.copyOf(planetas, contador);

			Arrays.sort(leidos);
			
			for (String s : leidos) {
				System.out.println(s);
			}

		} catch (IOException e) {
			e.getMessage();
		}*/
		
	} //no borrar xD

}
