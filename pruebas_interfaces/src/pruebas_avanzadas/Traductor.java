package pruebas_avanzadas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Traductor {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		

			URL direccion = new URL ("https://www.spanishdict.com/translate/gato");
			
			String html = obtenerHTML(direccion);
			String palabraTraducida = cortarHTML(html);
			
			System.out.println(palabraTraducida);

	}

	private static String obtenerHTML(URL direccion) throws IOException {
		
		BufferedReader in = new BufferedReader (new InputStreamReader (direccion.openStream()));
		String inputLine, codigo = "";
		
		while ((inputLine=in.readLine())!=null) {
			codigo+=inputLine; //lee lo que hay y nos lo devuelve
		}
		
		in.close();
		
		return codigo; //Va al HTML
	}
	
	
	private static  String cortarHTML (String html) {
		
		int inicio, puntoF1, puntoF2;
		
		//el index es la primera vez que aparece algo
		inicio = html.indexOf("?langFrom=en\" class=\"tCur1iYh\">");
		
		//Opcion 1
			//Crear sub cadena y biuscar desde ahi
		String trozo = html.substring(inicio);
		puntoF1 = trozo.indexOf("</a>");
		
		String resul1 = html.substring(inicio+31, inicio+puntoF1);
		
		//Opcion 2
			//Busca en la misma cadena desde el anterior punto
		puntoF2 = html.indexOf("</a>", inicio);
		
		
		String resul2 = html.substring(inicio+31, puntoF2);
		
		return resul2;
	}

}
