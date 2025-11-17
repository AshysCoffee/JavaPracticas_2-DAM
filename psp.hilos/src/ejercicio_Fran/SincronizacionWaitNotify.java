package ejercicio_Fran;

public class SincronizacionWaitNotify {

	private static final int NUM_HILOS = 6;
	
	private static final boolean[] flagsArrayHilosFinalizados = new boolean [NUM_HILOS];
	
	private static void inicializaFlagsArrayHilosFinalizados() {
		for (int i = 0; i < flagsArrayHilosFinalizados.length; i++) {
			flagsArrayHilosFinalizados[i] = false;
		}
	}
	
	public static void main(String[] args) {

		SincronizacionWaitNotify.inicializaFlagsArrayHilosFinalizados();
		
		for (int i = 0; i < args.length; i++) {
//			Runnable giulo = new MensajetoGriego();
//			Thread hAux = new Thread
		}
		
	}

}
