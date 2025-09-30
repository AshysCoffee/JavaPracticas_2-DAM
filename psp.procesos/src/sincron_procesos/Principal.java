package sincron_procesos;

public class Principal {

	public static void main(String[] args) {

		String ruta = "notepad";

		GeneradorProceso lanzador = new GeneradorProceso();

		lanzador.ejercutarYdestruir(ruta);
		
		System.out.println("El proceso proceso y la que como devoro");

		
	}

}
