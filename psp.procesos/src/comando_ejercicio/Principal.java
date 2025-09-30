package comando_ejercicio;

public class Principal {
	
	public static void main(String[] args) {
		
		String ruta = "ipconfig"; //para abrir la cmd se pone: cmd , /c, dir, *.java
		
		//String extra = "/all"; //<- mi solucion pero si ahora algo flexible
		
		String [] comandos = {"/all"};
		
		GeneradorProceso lanzador = new GeneradorProceso(); //objeto que puede creae procesos
		
		lanzador.ejercutar(ruta, comandos);
		
		
	}

}
