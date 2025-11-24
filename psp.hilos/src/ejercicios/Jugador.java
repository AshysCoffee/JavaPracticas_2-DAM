package ejercicios;

import java.util.Random;

public class Jugador extends Thread {

	final int contador = 20;

	public void run() {

		Random r = new Random();
		long mseconds = r.nextLong(1000);

		try {
			Thread.sleep(mseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
