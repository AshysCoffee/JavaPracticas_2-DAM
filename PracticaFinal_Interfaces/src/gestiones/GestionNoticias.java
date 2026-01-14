package gestiones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import modelos.Categorias;
import modelos.Fuentes;
import modelos.Usuario;

public class GestionNoticias {

	private List<Fuentes> listaNoticias;
	private List<String> titulares;
	private GestionUsuarios gu;

	public GestionNoticias(GestionUsuarios gu) {
		super();
		this.gu = gu;
		this.listaNoticias = new ArrayList<>();
		this.titulares = new ArrayList<>();
	}

	public List<Fuentes> getListaNoticias() {
		return listaNoticias;
	}

	public void setListaNoticias(List<Fuentes> listaNoticias) {
		this.listaNoticias = listaNoticias;
	}

	public List<String> getTitulares() {
		return titulares;
	}

	public void setTitulares(List<String> titulares) {
		this.titulares = titulares;
	}

	public void iniciarNoticias() {
		cargarFuentes();
	}

//////////////////	

	public Fuentes leerFuente(String linea) {

		linea = linea.replace("$$", "");

		String[] partes = linea.trim().split(";");

		if (partes.length < 4) {
			return null;
		}

		try {

			String categoria = partes[0];
			String periodico = partes[1];
			String url = partes[2];
			String css = partes[3];

			return new Fuentes(Categorias.valueOf(categoria), periodico, url, css);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error al procesar los datos de los titulares.", "Error de Sistema",
					JOptionPane.ERROR_MESSAGE);
		}
		return null;

	}

	public List<Fuentes> cargarFuentes() {

		BufferedReader bf = null;
		listaNoticias.clear();

		try {

			File f = new File("data/config.txt");

			if (!f.exists()) {
				return listaNoticias;
			}

			bf = new BufferedReader(new FileReader(f));

			String linea = bf.readLine();

			while (linea != null) {
				if (!linea.trim().isEmpty() && linea.startsWith("$$")) {
					Fuentes u = leerFuente(linea);
					if (u != null) {
						listaNoticias.add(u);
					}
				}

				linea = bf.readLine();

			}
			return listaNoticias;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar fuentes de noticias desde el archivo.", "Error",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				if (bf != null)
					bf.close();
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error al cargar fuentes de noticias, no se pudo leer.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		return listaNoticias;
	}
	

	public List<String> cargarTitulares(List<Fuentes> pref, String usuario) {

		titulares.clear();
		
		if (pref == null || pref.isEmpty()) {
            return titulares;
        }

		try {

			for (Fuentes f : pref) {

				String web = (f.getUrl());
				Document doc = Jsoup.connect(web).get();
				Element palabra = doc.select(f.getCss()).get(0);
				String resultado = palabra.text();

				titulares.add(resultado);

			}
			
			Usuario u = gu.buscarUsuario(usuario);
			
            if (u != null) {
                guardarHistorico(titulares, u.getUsuario());
            }
			
			return titulares;

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Sin conexión a Internet. Cargando últimas noticias guardadas.",
					"Modo Offline", JOptionPane.WARNING_MESSAGE);
			return leerHistorico();
		}

	}

	public void guardarHistorico(List<String> noticias, String u) {

		if (noticias == null || noticias.isEmpty()) {
			return;
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/historial.txt"))) {
			bw.write("////" + u + "////");
			for (String n : noticias) {
				bw.write(n);
				bw.newLine();
			}
			bw.write("////" + u + "////");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "No se pudo guardar en el historial, por favor contacte soporte.",
					"Error en la app", JOptionPane.WARNING_MESSAGE);
		}
	}

	public List<String> leerHistorico() {
		List<String> recuperadas = new ArrayList<>();
		try (BufferedReader bf = new BufferedReader(new FileReader("data/historico.txt"))) {
			String linea;
			while ((linea = bf.readLine()) != null) {
				recuperadas.add(linea);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "No se pudo leer el historial, por favor contacte soporte.",
					"Error en la app", JOptionPane.WARNING_MESSAGE);
			return new ArrayList<>();
		}
		return recuperadas;
	}

}
