package randomArch;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFile {
	
	public static void main(String[] args) {
		
		//int numeroLista; //4bytes
		String nombre = "Pedro"; // per caracter son 2 bytes x 20 = 40 btyes
		//double nota; //8 btyes
		
		
		try {
			
		File fichero = new File ("datos.dat");
		RandomAccessFile raf = new RandomAccessFile (fichero,"rw"); //documentar este constructor
			
			/*raf.writeInt(0); //4 bytes btw se empieza a contar desde 0 osea 0-3
			raf.writeInt(1); //4 btyes 4-7
			raf.writeInt(2);

			System.out.println(raf.getFilePointer()); //imprime 12 porque el archivo tiene 12 btyes
			raf.seek(4);
			System.out.println(raf.readInt()); //dado que antes puse el raf.seek me lee el numero que este en el byte numero 4
			
			raf.seek(0);
			while (raf.getFilePointer()<raf.length()) { //osea el seek es poner en posicion el lector, raf.readInt devuelve los 4 btye de cada numeor, cuando
				// que el numeor es menor al maximo, lee de nuevo otros 4 bytes y asi hasta que llega a la longitud maxizma +-lo que entendi
				System.out.println(raf.readInt());
			}*/
		
		raf.writeInt(1);
		raf.writeChars(nombre);
		raf.writeDouble(5.12);
		
		System.out.println(raf.getFilePointer());
			
		String cadena="";
		
		raf.seek(0);
		while (raf.getFilePointer()<raf.length()) { 
			System.out.println(raf.readInt());
			for (int i=0; i<nombre.length();i++) {
				cadena+=raf.readChar();
			}
			System.out.println(cadena);
			System.out.println(raf.readDouble());
			
		}
		
			raf.close();
			
		} catch (IOException e){
			e.printStackTrace();
			
		}
		
	}

	
}
