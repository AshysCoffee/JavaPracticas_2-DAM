package ejercicio1;

public class Principal {
	
	public static void main(String[] args) {
		
		String ruta = "notepad";
		String [] complementos = {"F:\\Warranty.pdf"};
		
		GeneradorProceso lanzador = new GeneradorProceso(); //objeto que puede creae procesos
		
		lanzador.ejercutar(ruta, complementos);
		
		
	}

}
