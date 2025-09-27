package lanz_cmd;

public class Principal {
	
	public static void main(String[] args) {
		
		//GeneradorProceso lanzador = new GeneradorProceso(); //objeto que puede creae procesos
		
		//si lo quiero como desde array
		
		String ruta = "cmd";
		String [] comandos = {"/C","dir","/p"};
		
		GeneradorProceso lanzador = new GeneradorProceso();
		
		lanzador.ejercutar(ruta, comandos);
		
		System.out.println("Proceso Ejecutado!!! :00000 whatthefuck que epiko hermano :0");
		
	}

}
