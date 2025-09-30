package pruebas;

public class Principal {
	
	public static void main(String[] args) {
		

		String ruta =("C:\\Windows\\System32\\cmd.exe");
		String [] nombre = {"/c"};
		
		GeneradorProceso lanzador = new GeneradorProceso(); //objeto que puede creae procesos
		
		lanzador.ejercutar(ruta,nombre);
		
		System.out.println("Proceso Ejecutado!!! :00000 whatthefuck que epiko hermano :0");
		
		
	}

}
