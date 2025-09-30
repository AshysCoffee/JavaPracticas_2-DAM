package comun_proceso;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GeneradorProceso {
	
	@SuppressWarnings("deprecation")
	public void ejercutar (String ruta) {
		
		Runtime rt = Runtime.getRuntime(); //es como hacer un proceso o idk la verdad xd
		
		Process proceso = null;
		String linea;
		
		try {
			
			//no preparamos el proceso
			proceso = rt.exec(ruta); //el hijo de runtime :P
			BufferedReader br = new BufferedReader /*salida del hijo*/(new InputStreamReader(proceso.getInputStream()/*entrada del padre*/));
			
			while ((linea=br.readLine())!=null) {
				System.out.println(linea);
			}
		}catch (Exception e ) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		if (proceso!=null) {
			proceso.destroy();
		}
		
		try {
			proceso.waitFor();
		}catch(InterruptedException e) {
			System.exit(2);
			
		}
	
	}
	
}