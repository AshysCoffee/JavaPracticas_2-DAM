package gestiones;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelos.Fuentes;
import modelos.Usuario;

public class GestionHistorial {

	private List<Fuentes> historial;  
	
	
	public GestionHistorial() {
		this.historial = new ArrayList <>();
	}


	public List<Fuentes> getHistorial() {
		return historial;
	}



	public void setHistorial(List<Fuentes> historial) {
		this.historial = historial;
	}



	public boolean guardarHistorico(Usuario u) {
		  
		  BufferedWriter bw = null;

			try {

				File f = new File("data/historial_"+u.getUsuario()+".txt");

				bw = new BufferedWriter(new FileWriter(f));

				bw.write(u.toStringUsuario());
				bw.newLine();
				
				for (Fuentes fuentes : historial) {
					bw.write(fuentes.toString());
				}
				
			
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

			return false;
	  }
	
}
