package ejercicios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Jugador cifras = new Jugador();
		Jugador letras = new Jugador();
		
		File f = new File ("salida.txt");
		
		try {
			
			BufferedWriter br = new BufferedWriter(new FileWriter(f));
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Imprime letras random xd");
		
		int numLetras = 'Z'-'A';
		
		for (int i = 0; i < 5; i++) {
			char letra = (char) (('A') + new Random().nextInt(numLetras));
			System.out.println(letra);
			
		}
		
	}

}
