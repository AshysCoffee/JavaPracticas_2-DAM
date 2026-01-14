package gestiones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import modelos.Fuentes;
import modelos.Usuario;

public class GestionPreferencias {

	private JCheckBox[] listaPreferencias;
	private GestionNoticias gn;
	private GestionUsuarios gu;

	public GestionPreferencias(GestionNoticias gn, GestionUsuarios gu) {
		this.gu = gu;
		this.gn = gn;
		this.listaPreferencias = new JCheckBox[18];
	}

	public JCheckBox[] getListaPreferencias() {
		return listaPreferencias;
	}

	public void setListaPreferencias(JCheckBox[] listaPreferencias) {
		this.listaPreferencias = listaPreferencias;
	}

	public void generarCadenaBinaria() {
		String cadenaBinaria = "";
		for (JCheckBox check : getListaPreferencias()) {
			cadenaBinaria += check.isSelected() ? "1" : "0";
		}
	}
	
	public String obtenerCadenaPreferencias(String nombreUsuario) {
		
		File f = new File("data/config.txt");
		
		if (!f.exists()) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error al procesar los datos.", "Error de Sistema",
					JOptionPane.ERROR_MESSAGE);
		}

			
		try (BufferedReader bf = new BufferedReader(new FileReader(f))) {
			String linea;
			while ((linea = bf.readLine()) != null) {
				linea = linea.trim();
				if (linea.startsWith("==")) {
					// Quitamos los == iniciales
					String contenido = linea.substring(2);
					// Separamos por ==
					String[] partes = contenido.split("==");

					if (partes.length >= 2) {
						String userEnFichero = partes[0];
						String prefs = partes[1];

						if (userEnFichero.equalsIgnoreCase(nombreUsuario)) {
							return prefs;
						}
					}
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error al procesar los datos.", "Error de Sistema",
					JOptionPane.ERROR_MESSAGE);
		}
		return "111111111111111111";
	}

	public boolean guardarPreferencias(JCheckBox[] listaPreferencias, Usuario u) {

		BufferedWriter bw = null;

		try {

			File f = new File("data/preferencias.txt");
			bw = new BufferedWriter(new FileWriter(f));
			bw.write(u.getUsuario() + "::");

			for (int i = 0; i < 18; i++) {

				bw.write(listaPreferencias[i].toString() + "::");
			}

			return true;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error al procesar los datos.", "Error de Sistema",
					JOptionPane.ERROR_MESSAGE);

			return false;
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null,
							"No se pudo ejecutar algo en el proyecto, por favor contacte soporte.", "Error en la app",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		}

	}


	public List<Fuentes> obtenerPreferencias(String nombreUsuario) {
		List<Fuentes> todasLasFuentes = gn.getListaNoticias();
		List<Fuentes> preferencias = new ArrayList<>();

		String cadenaBinar = obtenerCadenaPreferencias(nombreUsuario);

		try {
			for (int i = 0; i < todasLasFuentes.size(); i++) {
				if (i < cadenaBinar.length() && cadenaBinar.charAt(i) == '1') {
					if (i < todasLasFuentes.size()) {
						preferencias.add(todasLasFuentes.get(i));
					}
				}
			}
		} catch (Exception e) {
			System.err.println("Error al filtrar preferencias: " + e.getMessage());
		}

		return preferencias;
	}
	
}
