package extraerPaginas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerFicheros {

	
	
	
	public static List<String[]> leerUsuarios() {

		List<String[]> lista = new ArrayList<>();
		String[] datos = new String[5];
		String texto = "";
		BufferedReader bf = null;

		try {

			File f = new File("src/usuarios.txt");

			if (!f.exists()) {
				f.createNewFile();
				System.out.println("Se ha creado el archivo usuarios.txt");
			}

			if (f.exists()) {
				bf = new BufferedReader(new FileReader("src/usuarios.txt"));
				String linea = bf.readLine();
				while (linea != null) { // mientras no llegue al final del archivo

					datos = linea.split(";");
					texto = texto + linea + '\n'; // el cambio de línea hay que insertarlo manualmente
					linea = bf.readLine();
					lista.add(datos);

				}
			}
			
			System.out.println(texto);
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException ex) {
					System.out.println(ex);
				}
			}
		}

		return lista;

	}

	public void registroUsuario() {
		try {

			List<String[]> lista = leerUsuarios();

			for (String[] s : lista) {
				for (int i = 0; i < s.length; i++) {
					System.out.println(s[i]);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

	
		
		
	}

}
