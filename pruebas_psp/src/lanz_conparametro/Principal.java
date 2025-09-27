package lanz_conparametro;

public class Principal {
	
	public static void main(String[] args) {
		
	
		String ruta =("C:\\Windows\\System32");
		String nombre = "notepad.exe";
		
		GeneradorProceso lanzador = new GeneradorProceso(); //objeto que puede creae procesos
		
		lanzador.ejercutar(ruta,nombre);
		
		System.out.println("Proceso Ejecutado!!! :00000 whatthefuck que epiko hermano :0");
		
	}

}
