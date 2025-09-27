package sincron_procesos;

import java.io.IOException;
import java.util.ArrayList;

public class GeneradorProceso {
	
	public void ejercutarYdestruir(String ruta) {
		
		ArrayList <String> nombreArgumentos = new ArrayList<>();//array de cositas
		
		if(ruta==null || ruta.isEmpty()) {
			System.out.println("Falta nombre del comando");
		}
		
		nombreArgumentos.add(ruta); //se añade la ruta a los argumentos xd
		
		
		Process proceso = null;
		ProcessBuilder pb = new ProcessBuilder(nombreArgumentos); //<--- aqui puedo poner un string o un list	
		
		try {
			proceso=pb.start(); //comienza el proceso
			System.out.println("Se ha lanzado el proceso\nEl proceso padre esperara a que el hijo pare");
		} catch (IOException e){ //o hacer otro catch XD
			e.printStackTrace();
		}
		

		try {
			proceso.waitFor(); //obliga a bloquear el proceso
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Sacar valo de retporno del proceso
		// Destruir con destroy
	
		try {
			System.out.println(proceso.exitValue()); //aqui significa que se ha desbloqueado el proceso
		}catch (IllegalThreadStateException e) {
			e.getMessage();
		}

		if (proceso!=null) {
				proceso.destroy();
				System.out.println("EL proceso hijo se destruye");
		}
		
		}
	
	
}
