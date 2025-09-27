package comandos;

public class Principal {
	
	public static void main(String[] args) {
		
		String ruta = "ipconfig";
		
		GeneradorProceso lanzador = new GeneradorProceso(); //objeto que puede creae procesos
		
		lanzador.ejercutar(ruta);
		
		
	}

}
