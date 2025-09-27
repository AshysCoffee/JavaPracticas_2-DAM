package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Prueba_2ºDAM {
	
	public static void main(String[] args) {

		File f = new File ("FicheroEjemplo.txt");


		if (!f.exists()) { //primero verificar el fichero lol
			try {
				f.createNewFile(); //si no existe se crea
			} catch (IOException e) {
				e.getMessage();
			}
			
		}else{	 //si ya esta creado ->
			 
			/*System.out.println("Hola"); //texto random xd
			System.out.println("No entiendo porque no usa el BufferWriter que es mas facil");
			System.out.println("????");
			System.out.println("No se si a mi me enseñaron mal xD");
			System.out.println("gyomi!! :3");
			System.out.println("i dont get it??");
			System.out.println("Maybe I'm a bit silly :P");*/


			//FileWriter escritura = new FileWriter(f); //abre escritura???????

			try {
				BufferedWriter buffer_w = new BufferedWriter (new FileWriter(f, true)); //al tener true, lo que se imprime una vez se deja y se vuelve a imprimir
				//abre buffer

				for (int i=0; i<10;i++) {
					buffer_w.write("Linea "+i);
					buffer_w.newLine();

				}
				buffer_w.close(); // se cierra para dejar de escribir :v



				FileReader lector = new FileReader (f);
				BufferedReader buffer_r = new BufferedReader(lector);
				String linea;

				while ((linea=buffer_r.readLine())!=null){
					System.out.println(linea);
				}
				buffer_r.close();

			} catch (IOException e) {
				e.getMessage();
			
			}finally{
				System.out.println("Adios");
			} 


		}

	}

}
