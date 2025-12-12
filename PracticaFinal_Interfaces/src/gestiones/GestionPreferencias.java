package gestiones;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;

import modelos.Fuentes;
import modelos.Usuario;

public class GestionPreferencias {

	private List<Fuentes> categoriasElegidas;
	private JCheckBox [] listaPreferencias;
	private GestionNoticias gn;
	private GestionUsuarios gu;

	public GestionPreferencias(GestionNoticias gn, JCheckBox [] listaPreferencias, GestionUsuarios gu) {

		this.categoriasElegidas = new ArrayList<>();
		this.gn = gn;
		this.gu = gu;
		this.listaPreferencias = listaPreferencias;

	}

	public boolean guardarPreferencias(JCheckBox[] listaPreferencias, Usuario u) {

		BufferedWriter bw = null;

		try {

			File f = new File("data/preferencias.txt");

			bw = new BufferedWriter(new FileWriter(f));

			bw.write(u.getUsuario() + "::");

			for (int i = 0; i < 18; i++) {

				bw.write(listaPreferencias[i].toString()+"::");
			}

			return true;

		} catch (Exception e) {
			e.printStackTrace();
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
	
	
	public boolean leerPreferencias (String linea, String u) {
		
		String[] partes = linea.split("::");
		
		Usuario user = gu.buscarUsuario(u.trim());
	
		if (user!=null) {
		
		for (int i = 1 ; i<19; i++) {
			if (partes[i].equals("1")) {
				categoriasElegidas.add(gn.getListaNoticias().get(i-1));
			}
		}
		
		return true;
		}
		
		return false;
	}
	

//	public List<Fuentes> obtenerPreferencias (){
//		
//		
//		
//	}
	
	public List<String> noticiasUser(){
		
		List<String> titularesUsuario = gn.cargarTitulares(categoriasElegidas);
		
		return titularesUsuario;
		
	}
	
	
}
