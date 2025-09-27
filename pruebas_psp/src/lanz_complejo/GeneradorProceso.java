package lanz_complejo;

import java.util.ArrayList;
import java.util.List;

public class GeneradorProceso {
	
	@SuppressWarnings("unused")
	public void ejercutar () {
		
		List <String> nombreArgumentos = new ArrayList<>();
		nombreArgumentos.add("C:\\Mycode\\Sumar2Numeros.exe");
		nombreArgumentos.add("18");
		nombreArgumentos.add("20");
		
		ProcessBuilder pb = new ProcessBuilder();	//ProcessBuilder es la clase que se necesita para iniciar el proceso
		
	//try-catch :P	
	try {
		Process proceso = pb.start();
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	}
	
}