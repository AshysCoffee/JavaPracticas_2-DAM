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

import modelos.Usuario;

public class GestionUsuarios {

	public List<Usuario> listaUsuario= new ArrayList<>();
	

	public GestionUsuarios() {

	}
	
	///////////////

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}



	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

//////////////

	public  Usuario leerLinea(String linea) {

		boolean esAdmin = false;

		if (linea.startsWith("@@")) {
			esAdmin = true;
			linea = linea.replace("@@", "");
		} else if (linea.startsWith("//")) {
			linea = linea.replace("//", "");
		}

		String[] partes = linea.split(";");

		if (partes.length < 5) {
			return null;
		}

		String nombre = partes[0];
		String password = partes[1];
		String correo = partes[2];
		int contadorEntradas = Integer.parseInt(partes[3]);
		String preferencias = partes[4];

		return new Usuario(nombre, password, correo, esAdmin, contadorEntradas, preferencias);
	}

	public List<Usuario> cargarUsuarios() {

		BufferedReader bf = null;
		
		listaUsuario.clear();
		
		File f = new File("data/usuarios.txt");

		try {

			if (!f.exists()) {
				System.err.println("No existe el archivo.");
				return null;
			}

			bf = new BufferedReader(new FileReader(f));
			String linea = bf.readLine();

			while (linea != null) {
				if (!linea.trim().isEmpty()) {
					Usuario u = leerLinea(linea);
					if (u != null) {
						listaUsuario.add(u);
					}
				}

				linea = bf.readLine();

			}

			return listaUsuario;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, 
		            "Hubo problemas con los usuarios", 
		            "Error", JOptionPane.WARNING_MESSAGE);

		} finally {
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, 
				            "No se pudo ejecutar algo en el proyecto, por favor contacte soporte.", 
				            "Error en la app", JOptionPane.WARNING_MESSAGE);
				}
			}
		}

		return null;

	}

/////////////////

	public  Usuario buscarUsuario(String nick) {

		if (listaUsuario == null || listaUsuario.isEmpty()) {
			return null;
		}

		if (nick == null || nick.isEmpty()) {
			return null;
		}

		for (Usuario u : listaUsuario) {
			if (u.getUsuario().equals(nick.trim())) {
				return u;
			}
		}
		return null;
	}

	public  Usuario validarLogin(String nick, String contraseña) {
		
		if (nick == null || nick.isEmpty()) {
			return null;
		}

		if (contraseña == null || contraseña.isEmpty()) {
			return null;
		}

		if (listaUsuario == null || listaUsuario.isEmpty()) {
			return null;
		}

		Usuario u = buscarUsuario(nick.trim());

		if (u == null) {
			return null;
		}

		if (!u.getPwd().equals(contraseña)) {
			return null;
		}

		u.setVisitas(u.getVisitas() + 1);
		return u;
	}

	public  boolean guardarUsuarios() {
		
		BufferedWriter bw = null;

		try {

			File f = new File("data/usuarios.txt");

			bw = new BufferedWriter(new FileWriter(f));

			for (Usuario u : listaUsuario) {

				if (u.isEsAdmin() == true) {
					bw.write(u.toStringAdmin());
				} else {
					bw.write(u.toStringUsuario());
				}

				bw.newLine();
			}
			return true;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, 
		            "No se pudo ejecutar algo en el proyecto, por favor contacte soporte.", 
		            "Error en la app", JOptionPane.WARNING_MESSAGE);		
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

	public  boolean eliminarUsuario(String nick) {


		if (nick == null || nick.isEmpty()) {
			return false;
		}

		Usuario u = buscarUsuario(nick);

		if (u == null) {
			return false;
		} else {
			listaUsuario.remove(u);
			guardarUsuarios();
			return true;
		}

	}

	public boolean crearUsuario(String nick, String pwd, String email) {

		if (nick == null || nick.isEmpty()) {
			return false;
		}

		if (pwd == null || pwd.isEmpty()) {
			return false;
		}

		if (email == null || email.isEmpty()) {
			return false;
		}

		if (!ControlErrores.esCorreoValido(email)) {
			return false;
		}

		if (buscarUsuario(nick) != null) {
			return false;
		}

		Usuario u = new Usuario(nick, pwd, email, false, 0);

		BufferedWriter bw = null;

		try {

			bw = new BufferedWriter(new FileWriter("data/usuarios.txt", true));

			bw.write(u.toStringUsuario());
			bw.newLine();

			listaUsuario.add(u);

			return true;

		} catch (IOException e) {
			return false;
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, 
			            "No se pudo ejecutar algo en el proyecto, por favor contacte soporte.", 
			            "Error en la app", JOptionPane.WARNING_MESSAGE);
			}

		}

	}


}
