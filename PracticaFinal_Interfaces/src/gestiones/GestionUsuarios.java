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

	private List<Usuario> listaUsuario = new ArrayList<>();

	public GestionUsuarios() {
		this.listaUsuario = new ArrayList<>();
		cargarUsuarios();
	}

	///////////////

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

//////////////

	public Usuario leerLinea(String linea) {

		boolean esAdmin = false;

		if (linea.startsWith("@@")) {
			esAdmin = true;
			linea = linea.replace("@@", "");
		} else if (linea.startsWith("//")) {
			linea = linea.replace("//", "");
		}

		String[] partes = linea.split(";");

		if (partes.length < 4) {
			return null;
		}

		String nombre = partes[0];
		String password = partes[1];
		String correo = partes[2];
		int contadorEntradas = Integer.parseInt(partes[3]);

		return new Usuario(nombre, password, correo, esAdmin, contadorEntradas);
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
			JOptionPane.showMessageDialog(null, "Se ha producido un error al procesar los datos de los usuarios.", "Error de Sistema",
					JOptionPane.ERROR_MESSAGE);

		} finally {
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null,
							"No se pudo ejecutar el archivo de usuarios, por favor contacte soporte.", "Error en la app",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		}

		return null;

	}

/////////////////

	public Usuario buscarUsuario(String nick) {

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

	public Usuario validarLogin(String nick, String contraseña) {

		if (nick == null || nick.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El nombre de usuario no puede estar vacío.", "Error de Registro",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}

		if (contraseña == null || contraseña.isEmpty()) {
			JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacía.", "Error de Registro",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}

		if (listaUsuario == null || listaUsuario.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay usuarios registrados en el sistema.", "Error de Registro",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}

		Usuario u = buscarUsuario(nick.trim());

		if (u == null) {
			JOptionPane.showMessageDialog(null, "El usuario no existe.", "Error de Registro",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}

		if (!u.getPwd().equals(contraseña)) {
			JOptionPane.showMessageDialog(null, "La contraseña es incorrecta.", "Error de Registro",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}

	
		int visitas = u.getVisitas() + 1;
		u.setVisitas(visitas);
		
		guardarUsuarios();
		
		return u;
	}

	public boolean guardarUsuarios() {

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

	public boolean eliminarUsuario(String nick) {

		if (nick == null || nick.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El nombre de usuario no puede estar vacío.", "Error de Registro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		int usuariosNormales = 0;
        for (Usuario user : listaUsuario) {
            if (!user.isEsAdmin()) {
                usuariosNormales++;
            }
        }

        if (usuariosNormales <= 3) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar. Debe haber un mínimo de 3 usuarios activos.", "Restricción del Sistema", JOptionPane.WARNING_MESSAGE);
            return false;
        }
		
		Usuario u = buscarUsuario(nick);

		if (u == null) {
			JOptionPane.showMessageDialog(null, "El usuario no existe.", "Error de Registro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			listaUsuario.remove(u);
			guardarUsuarios();
			return true;
		}

	}

	
	public boolean guardarPreferenciasUsuario(Usuario u, String preferencias) {

		if (u == null) {
			JOptionPane.showMessageDialog(null, "El usuario no puede ser nulo.", "Error de Registro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		Usuario existente = buscarUsuario(u.getUsuario());

		if (existente == null) {
			JOptionPane.showMessageDialog(null, "El usuario no existe.", "Error de Registro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("data/config.txt", true));
			bw.write("=="+u.getUsuario()+"==" + preferencias);
			bw.newLine();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error al procesar los datos de cración del usuario.", "Error de Sistema",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null,
						"No se pudo ejecutar el proyecto dado a problemas por el usuario, por favor contacte soporte.", "Error en la app",
						JOptionPane.WARNING_MESSAGE);
			}

		}

		return guardarUsuarios();
	}
	
	public boolean crearUsuario(String nick, String pwd, String email) {

		if (listaUsuario.size() >= 10) {
            JOptionPane.showMessageDialog(null, "Límite alcanzado: El sistema no admite más de 10 usuarios.", "Error de Capacidad", JOptionPane.ERROR_MESSAGE);
            return false;
        }
		
		if (nick == null || nick.isBlank()) {
			JOptionPane.showMessageDialog(null, "El nombre de usuario no puede estar vacío.", "Error de Registro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (pwd == null || pwd.isBlank()) {
			JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacía.", "Error de Registro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (email == null || email.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El correo no puede estar vacío.", "Error de Registro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (!ControlErrores.esCorreoValido(email)) {
			JOptionPane.showMessageDialog(null, "El correo electrónico no es válido.", "Error de Registro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (buscarUsuario(nick) != null) {
			JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe. Elija otro.", "Error de Registro",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		Usuario u = new Usuario(nick.trim(), pwd.trim(), email.trim(), false, 0);

		BufferedWriter bw = null;

		try {

			bw = new BufferedWriter(new FileWriter("data/usuarios.txt", true));

			bw.write(u.toStringUsuario());
			bw.newLine();

			listaUsuario.add(u);

			return true;

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Se ha producido un error al procesar los datos de cración del usuario.", "Error de Sistema",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null,
						"No se pudo ejecutar el proyecto dado a problemas por el usuario, por favor contacte soporte.", "Error en la app",
						JOptionPane.WARNING_MESSAGE);
			}

		}

	}
	
	public String listarUsuarios() {
		
		String s = "";
		
		for (Usuario u : listaUsuario) {
			s+="·"+u.getUsuario()+"-"+u.getCorreo()+"\n";
		}
		
		return s;
	}

}
