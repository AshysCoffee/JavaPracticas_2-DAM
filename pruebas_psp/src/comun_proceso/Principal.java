package comun_proceso;

public class Principal {
	
	public static void main(String[] args) {
		
		String ruta = "ping" + " google.es";
		
		GeneradorProceso lanzador = new GeneradorProceso();
		
		//el resultado del hijo lo expulsa el padre
		
		lanzador.ejercutar(ruta);

		System.out.println("Proceso Ejecutado!!! :00000 whatthefuck que epiko hermano :0");
		
		
	}

}
