package pruebas_avanzadas;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Traductor {

	//Nota para hacer en casa -> ir a jsoup y descargar primera y tercera (en caso que no aparezca en el proyecto)
	//Ponerlo en el proyecto mque ya viene y añadir la primera normal en el buildpath y dentro de esa
	

	public static void main(String[] args) throws IOException {
		

//			URL direccion = new URL ("https://www.spanishdict.com/translate/gato");
//			
//  		String html = obtenerHTML(direccion);
//			String palabraTraducida = cortarHTML(html);
//			
//			System.out.println(palabraTraducida);
//			
//			System.out.println(palabraTraducida.toUpperCase());
			
			Scanner sc = new Scanner (System.in);
			
			System.out.println("Introduzca la palabra a traducir en ingles");
		
			String palabra_pedida = sc.nextLine();
		
			String web_traductor = ("https://www.spanishdict.com/translate/");
		
			String web = web_traductor + palabra_pedida;

			Document doc = Jsoup.connect(web).get();
			Element palabra = doc.select("div#quickdef1-es a.tCur1iYh").get(0);
			String resultado = palabra.html().toUpperCase();

			
			System.out.println("Your word is "+resultado+":3");
			
			
			
	}

	//METODOS NO BORRAR PORQUE ES LA FORMA ARCAICA
	
//	private static String obtenerHTML(URL direccion) throws IOException {
//		
//		BufferedReader in = new BufferedReader (new InputStreamReader (direccion.openStream()));
//		String inputLine, codigo = "";
//		
//		while ((inputLine=in.readLine())!=null) {
//			codigo+=inputLine; //lee lo que hay y nos lo devuelve
//		}
//		
//		in.close();
//		
//		return codigo; //Va al HTML
//	}
//	
//	
//	private static  String cortarHTML (String html) {
//		
//		int inicio, puntoF1, puntoF2;
//		
//		//el index es la primera vez que aparece algo
//		inicio = html.indexOf("?langFrom=en\" class=\"tCur1iYh\">");
//		
//		//Opcion 1
//			//Crear sub cadena y biuscar desde ahi
//		String trozo = html.substring(inicio);
//		puntoF1 = trozo.indexOf("</a>");
//		String resul1 = html.substring(inicio+31, inicio+puntoF1);
//		
//		//Opcion 2
//			//Busca en la misma cadena desde el anterior punto
//		puntoF2 = html.indexOf("</a>", inicio);
//		String resul2 = html.substring(inicio+31, puntoF2);
//		
//		return resul2;
//	}

}
