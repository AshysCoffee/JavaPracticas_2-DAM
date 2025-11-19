package traductor;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Operaciones {

	public static String traducir(String s) {

		try {

			String web = ("https://www.spanishdict.com/translate/"+s);
			Document doc;

			doc = Jsoup.connect(web).get();

			Element palabra = doc.select("div#quickdef1-es a.tCur1iYh").get(0);
			String resultado = palabra.html().toUpperCase();

			return resultado;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
	
