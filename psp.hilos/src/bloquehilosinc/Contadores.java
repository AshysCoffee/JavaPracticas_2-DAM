package bloquehilosinc;

public class Contadores {

	private long cont1 = 0;
	private long cont2 = 0;

	private final Object lock1 = new Object();
	private final Object lock2 = new Object();
	
	public void incrementar1 () {
		synchronized (lock1) {
			cont1++;
		}
	}
	
	public void incrementar2 () {
		synchronized (lock2) {
			cont1++;
		}
	}

	public synchronized long getCont1() {
		synchronized (lock1) {
		return cont1;
		}
	}

	public synchronized long getCont2() {
		synchronized (lock2) {
		return cont2;
		}
	}


	//ele ejercico es lanzar 10 hhilos ty tiene que ir uno a uno llegar hasta 100.000.000
	
	
}
