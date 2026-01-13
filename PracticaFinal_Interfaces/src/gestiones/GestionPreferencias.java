package gestiones;

import java.io.BufferedWriter;
import java.io.File;
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
	
	public JCheckBox[] getListaPreferencias() {
		return listaPreferencias;
	}
 
	public void setListaPreferencias(JCheckBox[] listaPreferencias) {
		this.listaPreferencias = listaPreferencias;
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
			JOptionPane.showMessageDialog(null, "Se ha producido un error al procesar los datos.", "Error de Sistema", JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException ex) {
					System.out.println(ex);
				}
			}
		}

	}


	public List<Fuentes> obtenerPreferencias(String nombreUsuario) {

		List<Fuentes> todasLasFuentes = gn.getListaNoticias();

		Usuario u = gu.buscarUsuario(nombreUsuario);
		
		List<Fuentes> preferencias = new ArrayList<>();
		
		try {
			
			u.getPreferencias();
			
			for (int i = 0; i < todasLasFuentes.size(); i++) {
				if (u.getPreferencias().charAt(i) == '1') {
					preferencias.add(todasLasFuentes.get(i));
				}
			}	
			

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error al procesar los datos.", "Error de Sistema", JOptionPane.ERROR_MESSAGE);
		}

		return preferencias;
	}


	public void generarCadenaBinaria() {
		String cadenaBinaria = "";
		for (JCheckBox check : getListaPreferencias()) {
			cadenaBinaria += check.isSelected() ? "1" : "0";
		}
	}
	
}
