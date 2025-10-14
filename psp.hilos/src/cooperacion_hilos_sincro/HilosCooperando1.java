package cooperacion_hilos_sincro;

public class HilosCooperando1 {	
	
	public static final int NUM_HILOS =10; 
	public static final int CUENTA_TOTAL =100000000; 
	public static void main(String[] args) {
		Contador contCompartido = new Contador();
		Thread [] hilos = new Thread[NUM_HILOS];
		for (int i = 0;i<10;i++) {
			Thread th = new Thread(new Hilo(i,CUENTA_TOTAL/NUM_HILOS,contCompartido));
			th.start();
			hilos[i]=th;

		}
		for (Thread h: hilos) {
			try {
				h.join();
			}catch (InterruptedException e) {
				System.out.println("Excepcion por interrumpido");
				e.getMessage();

			}
		}
		/*
			ArrayList <Thread> hilos = new ArrayList<Thread>();
			for (int i = 1;i<11;i++) {
				hilos.add(new Thread(new hilo("Hilo"+i,0))) ;
			}
		 */


		System.out.println("cuenta global: contador 1 = "+contCompartido.getContador1()
		+"\n contador 2 ="+contCompartido.getContador2());


	}



}