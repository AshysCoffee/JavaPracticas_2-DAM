package ejercicios_acc_directo_bin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Main_bin {

	public static void main(String[] args) {
	
		try {
			
			File fichero = new File ("personas.bin");
			RandomAccessFile raf = new RandomAccessFile (fichero,"rw"); //documentar este constructor
			
			Persona p1 = new Persona ("Chichu", 16);
			Persona p2 = new Persona ("Shishu", 21);

			
			for (int i = 0; i < p1.getNombre().length(); i++) {
				raf.writeChar(p1.getNombre().charAt(i));
			}
			raf.writeInt(p1.getEdad());

			
			
			for (int i = 0; i < p2.getNombre().length(); i++) {
				raf.writeChar(p2.getNombre().charAt(i));
			}
			raf.writeInt(p2.getEdad());

			
			String cadena = "";
			raf.seek(0);

			while (raf.getFilePointer()<raf.length()) { 
				
				System.out.println(raf.readInt());
				
				for (int i=0; i<6;i++) {
					cadena+=raf.readChar();
				}
				
				System.out.println(cadena);
				System.out.println(raf.readInt());
				
				
				
				for (int i=0; i<6;i++) {
					cadena = "";
					cadena+=raf.readChar();
				}
				
				System.out.println(cadena);
				System.out.println(raf.readInt());
				
			}
			
		} catch (IOException e){
			e.printStackTrace();
			
		}
		
	}

}
/*
 * 3.	Crea un programa que pida datos de personas como el nombre y la edad. 
 * Para guardar estos datos se define una clase denominada persona y en un fichero binario se 
 * guardan varias instancias de la persona. Después se debe crear una función que permita mostrar 
 * todas las personas que están almacenadas.  */