package original;

public class Principal {
	
	public static void main(String[] args) {
		
		GeneradorProceso lanzador = new GeneradorProceso(); //objeto que puede crea procesos
		
		lanzador.ejercutar("C:\\Windows\\System32\\notepad.exe"); //se crea el proceso dependiendo del codigo de la clase principal
		
		System.out.println("Proceso Ejecutado!!! :00000 whatthefuck que epiko hermano :0"); 
		
		
	}

}
