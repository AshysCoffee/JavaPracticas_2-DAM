package hilos;

public class Hilo implements Runnable {

	private final String nombre;

	Hilo(String nombre) {
		this.nombre = nombre;
	}

	public void run() {
		System.out.printf("Hola, soy un hilo %s. \n", this.nombre);
		System.out.printf("Hilo terminado. \n", this.nombre);
	}

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
