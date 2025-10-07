package cooperacion_hilos;

public class Hilo extends Contador implements Runnable {

	int numHilos, miParte, miCuenta = 0;
	private final Contador cont; //nadie lo puede cambiar
	
	public Hilo(int numHilos, int miParte, Contador cont) {
		super();
		this.numHilos = numHilos;
		this.miParte = miParte;
		this.cont = cont;
	}
	
	public int getCuenta() {
		return miCuenta;
	}

	@Override
	public void run() {
	
		for (int i = 0; i<miParte; i++) {
			this.cont.incrementar();// incrementa el contador compartido el de todos
			miCuenta++; //el mio propio per hilo
		}
		
		System.out.printf("Hilo %d terminado, cuenta: %d\n", numHilos, getCuenta());
		
	}
	
	
	
}
