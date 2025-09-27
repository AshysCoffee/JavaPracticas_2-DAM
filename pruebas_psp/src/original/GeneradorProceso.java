package original;

public class GeneradorProceso {
	
	public void ejercutar (String nombreEjecutable) {
		
		ProcessBuilder pb = new ProcessBuilder(nombreEjecutable);	//ProcessBuilder es la clase que se necesita para iniciar el proceso
		
	//try-catch :P	
	try {
		@SuppressWarnings("unused")
		Process proceso = pb.start();
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	}
	
}