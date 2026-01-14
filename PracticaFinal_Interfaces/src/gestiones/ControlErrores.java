package gestiones;

import java.io.File;

public class ControlErrores {

	public static boolean verificarArchivosObligatorios() {
		
		String[] archivosObligatorios = { "data/config.txt", "data/historial.txt", "data/usuarios.txt" };

		for (String ruta : archivosObligatorios) {
			File archivo = new File(ruta);

			if (!archivo.exists()) {
				return false;
			} 
		}

		return true;
	}

	public static boolean leerEntero(String mensaje) {

		String patronNumero = "\\d+"; // Solo dígitos

		if (!mensaje.matches(patronNumero)) {
			return false;
		} else {
			return true;
		}
	}

	
	
	public static boolean leerTexto(String mensaje) {
		String patronLetras = "[a-zA-Z]+";

		if (mensaje == null || !mensaje.matches(patronLetras)) {
			return false;
		} else {
			return true;
		}

	}

	
	
	public static boolean esCorreoValido(String email) {

		String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";

		// Si es null o no coincide con el patrón, devuelve false
		if (email == null || !email.matches(emailRegex)) {
			return false;
		} else {
			return true;
		}
	}

	

	
}
