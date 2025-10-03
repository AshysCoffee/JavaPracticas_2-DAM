package ejercicios_lect_escrit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		
		
		//OTRA FORMA SEGUN LA PROFE
		
		/*try (FileReader fichero = new FileReader ("bye.txt")){
			
			int caracter=0;
			
			while ((caracter=fichero.read())!=-1) {
				if (caracter!=32) {
					System.out.print((char)caracter);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
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
		
	
		//intento frustrado xd
		
		/*String texto = "Texto a pasar la expresión regular";
		texto=texto.toLowerCase();
		Pattern patron = Pattern.compile("[aeiou]"); patron que se pone en el que caso que usemos algo fijo
		Matcher match = patron.matcher(texto); la clase que se pone para eso????? <-- esto lo dieron en js yo no :3
		
		while (match.find()){
			
			int aes=0, ies=0, es=0, oes=0, ues=0;

			String letra = match.group();
			System.out.println(letra);
			
			if (letra=="a") {aes++;}
			
			if (letra=="e") {ies++;}
			
			if (letra=="i") {es++;}
			
			if (letra=="o") {oes++;}
			
			if (letra=="u") {ues++;}
		}
		*/
		
				//OTRA FORMA SEGUN LA PROFE
		
		/*int vocales=0;
		int total=0;
		
		Pattern patron = Pattern.compile("[aeiouAEIOU]"); 
		
		try (BufferedReader buffer_r = new BufferedReader(new FileReader("bye.txt"))){
			String linea;
			
			while ((linea=buffer_r.readLine())!=null){
				total+=linea.length();
				Matcher match = patron.matcher(linea);
				if(match.find()) {
					vocales++;
				}
			}
			System.out.println("\nVocales: "+vocales+"\nCaracteres: "+total);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
//------------------------------------------------------------------------------------------------------------------------		
		
		
		File f = new File ("F:\\Docs_Interesantes\\Restaurants.csv");
		
		
		if (f.exists()) { 
			try {
				
				BufferedReader buffer_r = new BufferedReader(new FileReader (f));
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

		
	
//------------------------------------------------------------------------------------------------------------------------		
		
		/*File f = new File ("D:\\Docs_Interesantes\\frutas.txt");
		
		
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
		}*/
		
	
		
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
