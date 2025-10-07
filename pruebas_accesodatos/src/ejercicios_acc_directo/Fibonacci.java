package ejercicios_acc_directo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		/*
		 * 1. Se tiene un programa que escribe los números de la serie de fibonacci en un
fichero binario, ese programa pide al usuario el número de números a
generar mientras los genera los escribe en un fichero binario y luego permite
recuperar el número de la serie calculado según la posición.*/
		
		File f = new File ("fibonacci.bin");

		if (!f.exists()){
			try {
				f.createNewFile();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}	
		
		try (RandomAccessFile raf = new RandomAccessFile (f,"rw")) {
			
			if (f.isFile()) {
			
					try {

						int numDigito, constante1, constante2, constante3, numResultado;

						Scanner sc= new Scanner (System.in);

						System.out.println("La secuancia de Fibonacci\n¿Cuantos digitos de las secuencias quiere ver?");

						constante1=0;
						constante2=1;
						numResultado=0;

						numDigito=sc.nextInt();

						if (numDigito==1) {
							System.out.println(""+constante1+"");}


						if (numDigito==2) {
							System.out.println(""+constante1+"");
							System.out.println(""+constante2+"");}

						if (numDigito>=3) {	
							numResultado=0; //contador para  cumplir lo pedido por el usuario
							raf.writeInt(0);
							raf.writeInt(1);
							do {
								constante3=constante1+constante2;
								raf.writeInt(constante3);
								constante1=constante2;
								constante2=constante3;
								numResultado++;
							}
							while (numResultado<=numDigito);
						}


						
						System.out.println("Secuencia de Fibbonaci");
						raf.seek(0);
						while (raf.getFilePointer()<raf.length()) { 
							System.out.println(raf.readInt());
							
						}
						
						System.out.println("Indica una posición para recuperar un numero:");
								
						int ubicacion = sc.nextInt();
						if (ubicacion <= 0 || ubicacion > numDigito) {
						    System.out.println("Posición no válida");
						} else {
						    raf.seek((ubicacion - 1) * 4);
						    System.out.println("Número en la posición " + ubicacion + ": " + raf.readInt());
						}
					
						System.out.println(raf.readInt());
						
						sc.close();
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				
			}else{
				System.out.println("Archivos es directorio y no se puede hacer lol");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
