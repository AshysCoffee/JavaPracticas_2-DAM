package gestiones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import modelos.Categorias;
import modelos.Fuentes;

public class GestionNoticias {

	private List<Fuentes> listaNoticias;

	public GestionNoticias() {
		super();
		this.listaNoticias = new ArrayList<>();
	}
	
	
	public List<Fuentes> getListaNoticias() {
		return listaNoticias;
	}

	public void setListaNoticias(List<Fuentes> listaNoticias) {
		this.listaNoticias = listaNoticias;
	}


//////////////////	
	

	public Fuentes leerFuente(String linea) {
		 
			String[] partes = linea.split(";");

			if (partes.length < 4) {
		        return null;
		    }
			
			String categoria = partes[0];
			String periodico = partes[1];
			String url = partes[2];
			String css = partes[3];
			
			return new Fuentes(Categorias.valueOf(categoria),periodico, url, css);

    } 
	
	
	public List<Fuentes> cargarFuentes() {

		BufferedReader bf = null;

		try {

			File f = new File("data/fuentes.txt");

			if (!f.exists()) {
				return listaNoticias;
			}

			
				bf = new BufferedReader(new FileReader("data/fuentes.txt"));
				String linea = bf.readLine();

				while (linea != null) {
					if (!linea.trim().isEmpty()) {
						Fuentes u = leerFuente(linea);
						if (u != null) {
							listaNoticias.add(u);
						}
					}

					linea = bf.readLine();

				}

				return listaNoticias;

			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException ex) {
					System.out.println(ex);
				}
			}
		}

		return null;

	}

///////////////////

	public static void main (String[] args) throws IOException {
		
		GestionNoticias gn = new GestionNoticias();
	
		List<Fuentes> noticias = gn.cargarFuentes();
		
//		for (Fuentes f : noticias) {
//			System.out.println(f);
//		}
		
		for (Fuentes f : noticias) {
			String web = (f.getUrl());
			Document doc = Jsoup.connect(web).get();
			Element palabra = doc.select(f.getCss()).get(0);
			String resultado = palabra.text();
			System.out.println(resultado);
		}
		
	}
	
	
}
