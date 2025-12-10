package extraerPaginas;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SacarURL {

	public static void main(String[] args) throws IOException {

//			String web = ("https://www.20minutos.es/nacional/");
//			Document doc = Jsoup.connect(web).get();
//			Element palabra = doc.select("h2.c-article__title a").get(0);
//			String resultado = palabra.html().toUpperCase();
//			System.out.println(resultado);

//			String web = ("https://www.telemadrid.es/noticias/nacional/");
//			Document doc = Jsoup.connect(web).get();
//			Element palabra = doc.select("div.mosaic__unit--1 a.lnk").get(0);
//			String resultado = palabra.html().toUpperCase();
//			System.out.println(resultado);

		String web = ("https://www.larazon.es/ciencia/");
		Document doc = Jsoup.connect(web).get();
		Element palabra = doc.select("h2.article__title ").get(0);
		String resultado = palabra.text();
		System.out.println(resultado);

	}

}
