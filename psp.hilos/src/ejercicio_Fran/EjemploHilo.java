package ejercicio_Fran;

public class EjemploHilo{
	
	public static int cantidad = 0;
	public static Integer contador = 20;
	
	public static void main (String [] args) {
	
	final int NUM_HILOS = 15;	
		
	//System.out.println("Soy el hilo principal");	

	MiHilo arrayHilos [] = new MiHilo [NUM_HILOS]; 
	
	for (int i = 0; i < NUM_HILOS; i++) {
		arrayHilos[i] = new MiHilo();
		arrayHilos[i].setName("H"+i);
		arrayHilos[i].start();
		
	}
	
//	Apuntes en programas B)
//	- Seccion critica = 
//	- Mutex = bloqueo un pedazo de codigo que no funcionara hasta que otro pedazo me de un elemento
	}

}
