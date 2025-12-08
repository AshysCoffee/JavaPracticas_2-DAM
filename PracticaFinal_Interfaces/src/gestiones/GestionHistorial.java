package gestiones;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelos.Fuentes;
import modelos.Usuario;

public class GestionHistorial {

	  public boolean guardarHistorico(Usuario u, List<Fuentes> noticias) {
		  
		  BufferedWriter bw = null;

			try {

				File f = new File("data/historial_"+u.getUsuario()+".txt");

				bw = new BufferedWriter(new FileWriter(f));

				bw.write(u.toStringUsuario());
				bw.newLine();
				
				
				
				

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
