package gestionRespuestas;

import java.util.ArrayList;

public class HilosCooperando1 {

	private static final int NUM_HILOS = 13;
	private static final int CUENTA_TOTAL = 2600;
	
	public static void main(String[] args) {
		
		ResultadosEncuestas c_compartido = new ResultadosEncuestas ();

		ArrayList <Thread> lista = new ArrayList <Thread>();

		for (int i = 0; i<NUM_HILOS; i++) {
			Thread hilonuevo = new Thread (new Hilo (i, CUENTA_TOTAL/NUM_HILOS, c_compartido));
			lista.add(hilonuevo);
			hilonuevo.start();
			//hilonuevo.run();

		}

		try {
			for (Thread h : lista) {
				h.join();
			}
		} catch (InterruptedException e) {
			System.err.println("Excepcion interrumpida");
		}

		System.out.printf("Cuenta global: %s\n", c_compartido.getContador());
		System.out.printf("Cuenta de votos a favor: %s\n", c_compartido.getContSi());
		System.out.printf("Cuenta de votos en contra: %s\n", c_compartido.getContNo());
		System.out.printf("Cuenta de votos neutrales: %s\n", c_compartido.getContNsNc());

	}

}
