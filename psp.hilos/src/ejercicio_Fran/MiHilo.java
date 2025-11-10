package ejercicio_Fran;

import java.util.Random;

public class MiHilo extends Thread{

@Override
	public void run() {
	
	Random r = new Random();
	long mseconds = r.nextLong(1000);
	
	try {
		Thread.sleep(mseconds);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
		System.out.println("Soy el hilo: " + this.getName());
	}
	
}
