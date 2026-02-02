package ping_pong;

import java.util.concurrent.Semaphore;

public class Jugador extends Thread {
	
	//AQUI SOLO SE INICIALIZA
	public final static Semaphore SEM1 = new Semaphore(1);
	public final static Semaphore SEM2 = new Semaphore(0);

	@Override
	public void run() {
		try {
			//while (true) { LOOP INFINITO
			for (int i = 0; i < 10; i++) {
				// TE APROPIAS DEL SEM1
				SEM1.acquire();
				System.out.print(" ping - ");
				SEM2.release(); // DOY PASO, NOTIFICAS
			
				 // si hace ping pasas a pong
					SEM2.acquire();
					System.out.print(" pong - ");
					SEM1.release();
				}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}