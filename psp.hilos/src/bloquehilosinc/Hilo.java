package bloquehilosinc;

public class Hilo extends Contadores implements Runnable {

	int numHilos;
	private long vueltas=1000000000;
	private final Contadores cont; //nadie lo puede cambiar
	
	public Hilo(int numHilos, long vueltas, Contadores cont) {
		super();
		this.numHilos = numHilos;
		this.vueltas = vueltas;
		this.cont = cont;
	}
	
	public long getVueltas() {
		return vueltas;
	}

	@Override
	public void run() {
	
		for (int i = 0; i<vueltas; i++) {
			this.cont.incrementar1();
		}
		
		for (int i = 0; i<vueltas; i++) {
			this.cont.incrementar2();
		}
		
		System.out.printf("Hilo %d terminado, cuenta: %d\n", numHilos, getVueltas());
		
	}
	
	
	
}
