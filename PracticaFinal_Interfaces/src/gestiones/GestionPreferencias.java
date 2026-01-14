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

	private List<Fuentes> categoriasElegidas;
	private JCheckBox[] listaPreferencias;
	private GestionNoticias gn;
	private GestionUsuarios gu;

	public GestionPreferencias() {

		this.categoriasElegidas = new ArrayList<>();

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
			
			return false;
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, 
				            "No se pudo ejecutar algo en el proyecto, por favor contacte soporte.", 
				            "Error en la app", JOptionPane.WARNING_MESSAGE);
				}
			}
		}

	}

	public boolean leerPreferencias(String linea, String u) {

		String[] partes = linea.split("::");

		String usuarioTxt = partes[0];

		Usuario user = gu.buscarUsuario(usuarioTxt.trim());

		if (user != null) {

			for (int i = 1; i < 19; i++) {
				if (partes[i].equals("1")) {
					categoriasElegidas.add(gn.getListaNoticias().get(i - 1));
				}
			}

			return true;
		}

		return false;
	}

	public List<Fuentes> obtenerPreferencias(String nombreUsuario) {

		List<Fuentes> preferencias = new ArrayList<>();

		List<Fuentes> todasLasFuentes = gn.getListaNoticias();

		BufferedReader bf = null;

		try {
			bf = new BufferedReader(new FileReader("data/preferencias.txt"));
			String linea = bf.readLine();

			while (linea != null) {

				String[] partes = linea.split("::");

				if (partes.length >= 19) {

					if (partes[0].contains(nombreUsuario)) {

						for (int i = 1; i < partes.length; i++) {

							String valor = partes[i];

							if (valor.equals("1")) {

								if ((i - 1) < todasLasFuentes.size()) {
									Fuentes fuenteElegida = todasLasFuentes.get(i - 1);
									preferencias.add(fuenteElegida);
								}
							}

						}

					}
				}

				linea = bf.readLine();
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, 
		            "No se pudo ejecutar algo en el proyecto, por favor contacte soporte.", 
		            "Error en la app", JOptionPane.WARNING_MESSAGE);
		} finally {
			try {
				if (bf != null)
					bf.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, 
			            "No se pudo ejecutar algo en el proyecto, por favor contacte soporte.", 
			            "Error en la app", JOptionPane.WARNING_MESSAGE);
			}
		}

		return preferencias;
	}

	public JCheckBox[] getListaPreferencias() {
		return listaPreferencias;
	}

	public void setListaPreferencias(JCheckBox[] listaPreferencias) {
		this.listaPreferencias = listaPreferencias;
	}



}
