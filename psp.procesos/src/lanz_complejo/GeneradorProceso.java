package lanz_complejo;

import java.util.ArrayList;
import java.util.List;

public class GeneradorProceso {
	
	public void ejercutar () {
		
		List <String> nombreArgumentos = new ArrayList<>(); //se crea el List y se añaden cosas
		nombreArgumentos.add("C:\\Mycode\\Sumar2Numeros.exe");
		nombreArgumentos.add("18");
		nombreArgumentos.add("20");
		
		ProcessBuilder pb = new ProcessBuilder(nombreArgumentos);	//ProcessBuilder es la clase que se necesita para iniciar el proceso
		//se pone los argumentos para iniciar el proceso dado que la ruta esta adentro del List
		
	//try-catch :P	
	try {
		@SuppressWarnings("unused")
		Process proceso = pb.start();
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	}
	
}