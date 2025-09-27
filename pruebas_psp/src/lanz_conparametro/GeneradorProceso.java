package lanz_conparametro;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneradorProceso {
	
	public void ejercutar (String rutaDirectorio, String nombreEjecutable) {
		
		List <String> nombreArgumentos = new ArrayList<>();
		nombreArgumentos.add(nombreEjecutable);
		
		@SuppressWarnings("unused")
		File directorio = new File (rutaDirectorio);
		
		ProcessBuilder pb = new ProcessBuilder();	//ProcessBuilder es la clase que se necesita para iniciar el proceso
		
		pb.command(nombreEjecutable);
		
		pb.directory();
		
	}
	
}