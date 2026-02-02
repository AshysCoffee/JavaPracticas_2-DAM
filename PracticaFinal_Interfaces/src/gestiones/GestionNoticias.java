package gestiones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
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
	private GestionPreferencias gp;
	private LocalDate fecha = LocalDate.now();

	public GestionNoticias(GestionUsuarios gu, GestionPreferencias gp) {
		super();
		this.gu = gu;
		this.gp = gp;
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
		cargarTitulares(listaNoticias, null);
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
			JOptionPane.showMessageDialog(null, "Se ha producido un error al procesar los datos de los titulares.",
					"Error de Sistema", JOptionPane.ERROR_MESSAGE);
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

				String tipo = f.getCategoria().toString();
				String periodico = f.getPeriodico();
				String web = (f.getUrl());
				Document doc = Jsoup.connect(web).get();
				Element palabra = doc.select(f.getCss()).get(0);
				String resultado =  tipo +"\n"+periodico +" - "+ palabra.text();

				titulares.add(resultado);

			}


			return titulares;

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Sin conexión a Internet. No se mostraran noticias actualizadas.",
					"Modo Offline", JOptionPane.WARNING_MESSAGE);
			return titulares;
		}

	}

	public void guardarNoticiasFiltradas(String usuario,String criterio, String valor) {
	   
	    String nombreArchivo = "data/historial.txt";

	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
	        
	        int guardadas = 0;
	        bw.write("=== NOTICIAS EXPORTADAS ===\n");
	        bw.write("Filtro aplicado: " + criterio + " -> " + valor + "\n\n");
	        
	        List<Fuentes> pref = obtenerPreferencias(usuario);
	        List<String> titulares = cargarTitulares(pref, usuario);

	        for (int i = 0; i < titulares.size(); i++) {
	            
	        	Fuentes f = pref.get(i);
	        	
	            String titular = "Titular no disponible";
	            if (i < pref.size()) {
	                titular = titulares.get(i);
	            }

	            boolean guardar = false;

	        
	            if (criterio.equalsIgnoreCase("TODAS")) {
	                guardar = true;
	            } 
	            else if (criterio.equalsIgnoreCase("CATEGORIA")) {
	                if (f.getCategoria().toString().equalsIgnoreCase(valor)) {
	                    guardar = true;
	                }
	            } 

	            if (guardar) {
	            	bw.write("---"+usuario+"-"+fecha+"------------------------\n");
	                bw.write("--------------------------------------------------\n");
	                bw.write("CATEGORÍA: " + f.getCategoria() + "\n");
	                bw.write("MEDIO:     " + f.getPeriodico() + "\n");
	                bw.write("TITULAR:   " + titular + "\n");
	                bw.write("ENLACE:    " + f.getUrl() + "\n");
	                bw.newLine();
	                guardadas++;
	            }
	        }

	        if (guardadas > 0) {
	            JOptionPane.showMessageDialog(null, 
	                "¡Exito! Se han guardado " + guardadas + " noticias en '" + nombreArchivo + "'");
	        } else {
	            JOptionPane.showMessageDialog(null, 
	                "No se encontraron noticias con ese criterio.", "Aviso", JOptionPane.WARNING_MESSAGE);
	        }

	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, 
	            "Error al guardar el archivo del historial", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	
	public List<Fuentes> obtenerPreferencias(String nombreUsuario) {
		List<Fuentes> todasLasFuentes = getListaNoticias();
		List<Fuentes> preferencias = new ArrayList<>();

		String cadenaBinar = gp.obtenerCadenaPreferencias(nombreUsuario);

		try {
			for (int i = 0; i < todasLasFuentes.size(); i++) {
				if (i < cadenaBinar.length() && cadenaBinar.charAt(i) == '1') {
					if (i < todasLasFuentes.size()) {
						preferencias.add(todasLasFuentes.get(i));
					}
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo ejecutar algo en el proyecto, por favor contacte soporte.",
					"Error en la app", JOptionPane.WARNING_MESSAGE);
		}

		return preferencias;
	}
	
	
	public List<String> obtenerHistorialNoticias() {
	   
		List<String> historial = new ArrayList<>();
	    BufferedReader br = null;

	    try {
	        File f = new File("data/historial.txt");

	        if (!f.exists()) {
	            return historial;
	        }

	        br = new BufferedReader(new FileReader(f));
	        String linea = br.readLine();

	        while (linea != null) {
	            historial.add(linea);
	            linea = br.readLine();
	        }
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Error al cargar el historial de noticias desde el archivo.", "Error",
	                JOptionPane.ERROR_MESSAGE);
	    } finally {
	        try {
	            if (br != null)
	                br.close();
	        } catch (IOException ex) {
	            JOptionPane.showMessageDialog(null, "Error al cargar el historial de noticias, no se pudo leer.", "Error",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	    }
	    return historial;
	}

}
