package ejercicio_Fran;

import java.util.Date;

public class MensajeroGriego implements Runnable {

	@Override
	public void run() {

		///Convierto el numero del hilo en un número para mostrarlo en pantalla

		int threadNumber = Integer.parseInt(Thread.currentThread().getName());
		System.out.println("Comienza la ejecucion del hilo => " + threadNumber);

		// El tiempo en sistema informaticos se mide en ms desde las 00:00:00 del 1/1/70
		long tsInicio = (new Date()).getTime();

		try {
			// Simulamos que el hilo vive 2 segundos.
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long tsFinalizacion = (new Date()).getTime();

		System.out.println("--[LLEGO A LA META]-- FINNNN DEL HILOOOOOOOO => " + threadNumber+ "\nTARDE " + (tsFinalizacion - tsInicio) / 1000.0f);

		registraFinEjecucionHilo(threadNumber);
	}

	public void registraFinEjecucionHilo(int threadNumber) {
		
		
//		boolean [] arrayHilosFinalizados = SincronizacionWaitNotify.getFlagArrayHilosFinalizados();
//		arrayHilosFinalizados [threadNumber -1] = true;
//		
//		for (boolean b : arrayHilosFinalizados) {
//			if (b)
//		}
		
	}

}
