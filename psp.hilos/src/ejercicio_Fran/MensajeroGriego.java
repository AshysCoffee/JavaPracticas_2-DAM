package ejercicio_Fran;

import java.util.Date;

public class MensajeroGriego implements Runnable {

	 @Override
	    public void run() {

	        int threadNumber = Integer.parseInt(Thread.currentThread().getName());

	        long tsInicio = (new Date()).getTime();

	        System.out.println("COMIENZA LA EJECUCIÓN EL HILO => " + threadNumber);

	        try {
	            // Simulamos que el hilo vive 2 secs.
	            Thread.sleep(2000);
	        } catch (InterruptedException ex) {
	            ex.printStackTrace();
	        }

	        long tsFinalización = (new Date()).getTime();
	        System.out.println("[LLEGÓ A LA META] FINNNN DEL HILO => " + threadNumber
	                + "\n\tTARDÉ " + (tsFinalización - tsInicio) / 1000.0f);

	        registraFinEjecuciónHilo(threadNumber);
	    }

	 
	 
	 		protected synchronized void registraFinEjecuciónHilo(int threadNumber) {
	        boolean[] arrayHilosFinalizados = SincronizacionWaitNotify.getFlagsArrayHilosFinalizados();
	        arrayHilosFinalizados[threadNumber - 1] = true;

	        // Recorremos el array para comprobar si TODOS los hilos han acabado la carrera
	        //boolean todosHilosFinalizaron = true;
	        for (boolean b : arrayHilosFinalizados) {
	            // Si alguno de ellos no ha acabado, salimos del método
	            if (b == false) {
	                return;
	            }
	        }

	        // Imprimimos por pantalla qué hilo anuncia llega el último a la meta
	        // y lo NOTIFICA al hilo principal
	        System.out.println("Soy  >> " + threadNumber + " << el último hilo en llegar a meta, y he finalizado"
	                + "\n\tSE LO COMUNICO AL HILO MAINNNNNNNN");

	        // Notificamos al hilo principal que todos los hilos acabaron su procesamiento
	        synchronized (arrayHilosFinalizados) {
	            arrayHilosFinalizados.notify();
	        }
	    }

}
