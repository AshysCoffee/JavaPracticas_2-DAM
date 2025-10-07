package cooperacion_hilos;

public class HilosCooperando1 {

	private static final int NUM_HILOS = 10;
	private static final int CUENTA_TOTAL = 1000;
	
	public static void main(String[] args) {

	/*	Thread h1 = new Thread (new Hilo (c , "h1"));
		Thread h2 = new Thread (new Hilo (c , "h2"));
		Thread h3 = new Thread (new Hilo (c , "h3"));
		Thread h4 = new Thread (new Hilo (c , "h4"));
		Thread h5 = new Thread (new Hilo (c , "h5"));
		Thread h6 = new Thread (new Hilo (c , "h6"));
		Thread h7 = new Thread (new Hilo (c , "h7"));
		Thread h8 = new Thread (new Hilo (c , "h8"));
		Thread h9 = new Thread (new Hilo (c , "h9"));
		Thread h10 = new Thread (new Hilo (c , "h10"));
		
		
		ArrayList <Thread> listaHilos = new ArrayList<Thread>();
		
		listaHilos.add(h1);
		listaHilos.add(h2);
		listaHilos.add(h3);
		listaHilos.add(h4);
		listaHilos.add(h5);
		listaHilos.add(h6);
		listaHilos.add(h7);
		listaHilos.add(h8);
		listaHilos.add(h9);
		listaHilos.add(h10);
		
		for (Thread h : listaHilos) {
			h.start();
		}*/
		
		Contador c_compartido = new Contador ();

		Thread [] ArrayHilos = new Thread [NUM_HILOS];

		for (int i = 0; i<NUM_HILOS; i++) {
			Thread hilonuevo = new Thread (new Hilo (i, CUENTA_TOTAL/NUM_HILOS, c_compartido));
			hilonuevo.start();
			ArrayHilos [i] = hilonuevo;
		}

		try {
			for (Thread h : ArrayHilos) {
				h.join();
			}
		} catch (InterruptedException e) {
			System.err.println("Excepcion interrumpida");
		}

		System.out.printf("Cuenta global: %s\n", c_compartido.getContador());

		/*h1.start();
		h2.start();
		h3.start();
		h4.start();
		h4.start();
		h5.start();
		h6.start();
		h7.start();
		h8.start();
		h9.start();
		h10.start();*/
		

	}

}
