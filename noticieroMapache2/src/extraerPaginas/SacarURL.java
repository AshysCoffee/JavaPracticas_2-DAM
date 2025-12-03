package extraerPaginas;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SacarURL {

	public static void main(String[] args) throws IOException {

		int contador = 0;

		while (contador < 5) {
			String web = ("https://www.20minutos.es/nacional/");
			Document doc = Jsoup.connect(web).get();
			Element palabra = doc.select("h2.c-article__title a").get(0);
			String resultado = palabra.html().toUpperCase();
			System.out.println(resultado);
			contador++;
		}

		

	}

}
