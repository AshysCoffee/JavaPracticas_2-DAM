package hilos;

import java.util.Random;

public class Hilo implements Runnable {

	private final String nombre;

	Hilo(String nombre) {
		this.nombre = nombre;
	}

	public void run() {
		System.out.printf("Hola, soy un hilo %s. \n", this.nombre);
		for (int i = 0; i < 5; i++) {
			Random r = new Random();
			int pausa = 20 + r.nextInt(25, 500);
			System.out.printf("Hilo %s hace pausa %d ms. \n", this.nombre, pausa);

			//%s = string , %d = numero entero
			//se pone las variables separas de come dependiendo del porcentaje
			
			try {
				Thread.sleep(pausa);
			} catch (InterruptedException e) {
				System.out.printf("Hilo %s interrumpido. \n", this.nombre);
			}
			
		}
		System.out.printf("Hilo %s terminado. \n", this.nombre);
	}

}
