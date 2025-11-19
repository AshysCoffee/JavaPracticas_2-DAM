package ejercicio_ping_pong;

import java.util.concurrent.Semaphore;

public class Jugador extends Thread{

	private final static Semaphore SEM1 = new Semaphore (1);
	private final static Semaphore SEM2 = new Semaphore (0);
	
//	private Thread h1;
//	private Thread h2;
//	
//	public Jugador (Thread h1, Thread h2) {
//		this.h1 = h1;
//		this.h2 = h2;
//	}
	
	public void run() {
	
		try {

			for (;;) {
				SEM1.acquire();
				System.out.println("PING");
				SEM2.release();

				while (true) {
					SEM2.acquire();
					System.out.println("PONG");
					SEM1.release();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
