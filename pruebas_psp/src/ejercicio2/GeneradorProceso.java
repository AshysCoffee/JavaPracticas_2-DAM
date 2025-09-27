package ejercicio2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class GeneradorProceso {
	
	public static int maxTiempo = 30;
	
	public void ejercutar (String ruta, String [] extra) {
		
		List <String> nombreArgumentos = new ArrayList<>();
	
		if(ruta==null || ruta.isEmpty()) {
			System.out.println("Falta nombre del comando");
			System.exit(1); //este numero marca el problema
		}
		
		nombreArgumentos.add(ruta);
		
		
		for (int i=0; i<extra.length; i++) {
				nombreArgumentos.add(extra[i]);
			}

		
		ProcessBuilder pb = new ProcessBuilder();	//ProcessBuilder es la clase que se necesita para iniciar el proceso
		pb.command(nombreArgumentos);

		//llamada inheritIO  () <-- hace que el proceso herede la E/S = entrada y salida estandar del proceso padre
		//asi podemos ver el resultado del comando
		
		pb.inheritIO();
		
		
		try {
			Process proceso = pb.start();

			proceso.waitFor(maxTiempo, TimeUnit.SECONDS);
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("El comando devuelve: 0");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");

			/*if (cod_retorno==0) {
				System.out.println("\nEJECUCION CORRECTA!!!!!!! YUPIII ( ° ∀ ° )ﾉﾞ ");
			}else {
				System.out.println("Ejecución con errores :-(");
			}*/

		} catch (IOException e){ //o hacer otro catch XD
			System.out.println("Error durante la ejecución del comando");
			System.out.println("INFORMACIÓN ADICIONAL");
			e.printStackTrace();
			System.exit(2);
		} catch (InterruptedException e) {
			System.err.println("Proceso interrumpido");
			System.exit(3);
		}


	
	}
	

}
