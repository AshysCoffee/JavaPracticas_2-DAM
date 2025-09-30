package hilos;

public class LanzaHilos {

	public static void main(String[] args) {

		System.out.println("Vamos a  activar 2 hilos :3");
		
		// Hilo mihilo1 = new Hilo ("H1");
		// Thread h1 = new Thread(mihilo1);

		Thread h1 = new Thread(new Hilo("H1"));
		// me gusta más asi porque ahorro lineas xd

		Thread h2 = new Thread(new Hilo("H2"));

		h1.start();
		h2.start();

		System.out.println("Hilo Principal terminado");
	}

}
