package ejercicio_Fran;

public class SincronizacionWaitNotify {

	private static final int NUM_HILOS = 6;
	
	private static final boolean[] flagsArrayHilosFinalizados = new boolean [NUM_HILOS];
	
	private static void inicializaFlagsArrayHilosFinalizados() {
        for (int i = 0; i < NUM_HILOS; i++) {
            flagsArrayHilosFinalizados[i] = false;
        }
    }


    public static void main(String[] args) {

        // Invocamos al método static para inicializar el array
        SincronizacionWaitNotify.inicializaFlagsArrayHilosFinalizados();

        for (int i = 0; i < NUM_HILOS; i++) {
            Runnable hilo = new MensajeroGriego();
            Thread hAux = new Thread(hilo);
            hAux.setName(Integer.toString(i + 1));
            
            // Lanzo la ejecución de cada hilo
            hAux.start();
        }

        try {
            synchronized (flagsArrayHilosFinalizados) {
                flagsArrayHilosFinalizados.wait();
            }
            System.out.println("\n=== DESDE MAIN ANUNCIAMOS QUE TODOS LOS HILOS ACABARON LA CARRERA!!! ===");
        } catch (InterruptedException ex) {
           ex.printStackTrace();
        }
    }

    /**
     * Getter para encapsular el array con el estado de los hilos
     * @return boolean[] El array con los estados
     */
    public static boolean[] getFlagsArrayHilosFinalizados() {
        return flagsArrayHilosFinalizados;
    }
}
