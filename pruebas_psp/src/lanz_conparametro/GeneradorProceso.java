package lanz_conparametro;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneradorProceso {
	
	public void ejercutar (String rutaDirectorio, String nombreEjecutable) {
		
		List <String> nombreArgumentos = new ArrayList<>();
		nombreArgumentos.add(nombreEjecutable); //añadimos argumentos
		
		File directorio = new File (rutaDirectorio); //lo volvemos file para establecerlo como directorio
		
		ProcessBuilder pb = new ProcessBuilder();	//ProcessBuilder es la clase que se necesita para iniciar el proceso
		
		pb.directory(directorio); //establecemos la ruta
		
		pb.command(nombreEjecutable); //ponemos el comando 
		
		try {
			@SuppressWarnings("unused")
			Process proceso = pb.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}