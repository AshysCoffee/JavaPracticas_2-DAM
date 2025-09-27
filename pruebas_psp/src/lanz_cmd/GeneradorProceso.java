package lanz_cmd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GeneradorProceso {
	
	public void ejercutar (String ruta, String [] extra) {
		
		List <String> nombreArgumentos = new ArrayList<>();

		/*nombreArgumentos.add("cmd.exe");
		nombreArgumentos.add("start");
		nombreArgumentos.add("/C");
		nombreArgumentos.add("dir");*/


		if(ruta==null || ruta.isEmpty()) {
			System.out.println("Falta nombre del comando");
			System.exit(1); //este numero marca el problema
		}

		nombreArgumentos.add(ruta);


		for (int i=0; i<extra.length; i++) {
			nombreArgumentos.add(extra[i]);
		}

		ProcessBuilder pb = new ProcessBuilder(nombreArgumentos);	//ProcessBuilder es la clase que se necesita para iniciar el proceso

	//try-catch :P	
		try {
			Process proceso = pb.start();
			String linea;

			try {
				
				BufferedReader br = new BufferedReader /*salida del hijo*/(new InputStreamReader(proceso.getInputStream()/*entrada del padre*/));

				while ((linea=br.readLine())!=null) {
					System.out.println(linea);
				}
			}catch (Exception e ) {
				e.printStackTrace();
				System.exit(-1);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}