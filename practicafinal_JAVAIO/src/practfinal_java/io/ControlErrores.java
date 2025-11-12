package practfinal_java.io;

import java.io.File;

public class ControlErrores {

	// MODIFICAR LOS METODOS Y DOCUMENTAR DIOS YA NO PUEDO AAAAAA

	public void verificarYCrearDirectorios() {

		System.out.println("Verificando estructura de directorios...");

		String[] carpetasNecesarias = { "PLANTAS", "EMPLEADOS", "EMPLEADOS/BAJAS", "TICKETS", "DEVOLUCIONES" };

		boolean existente = true;

		for (String ruta : carpetasNecesarias) {
			File carpeta = new File(ruta);

			try {

				if (!carpeta.exists()) {
					System.out.println("Creando carpeta '" + ruta);
					carpeta.mkdirs();
					System.out.println("Carpeta '" + ruta + "' creada correctamente");
				}

			} catch (Exception e) {
				System.out.println("Error al crear carpeta '" + ruta + "'");
				existente = false;
			}

			if (existente) {
				System.out.println("Estructura de directorios verificada correctamente");
			} else {
				System.out.println("Hubo problemas al crear la estructura de directorios");
			}
		}

	}

	public boolean verificarArchivosObligatorios() {
		System.out.println("Verificando archivos obligatorios...");

		boolean todosExisten = true;

		// Archivos que DEBEN existir
		String[] archivosObligatorios = {
				"PLANTAS/plantas.xml",
				"PLANTAS/plantas.dat",
				"EMPLEADOS/empleado.dat"
		};

		for (String ruta : archivosObligatorios) {
			File archivo = new File(ruta);

			if (!archivo.exists()) {
				System.out.println(" Archivo obligatorio no encontrado: " + ruta);
				todosExisten = false;
			} else {
				System.out.println(" Se encontrado la ruta: " + ruta);
			}
		}

		if (!todosExisten) {
			System.out.println("\n Faltan archivos obligatorios.");
			System.out.println("Por favor, asegúrate de tener:");
			System.out.println("  - PLANTAS/plantas.xml");
			System.out.println("  - PLANTAS/plantas.dat");
			System.out.println("  - EMPLEADOS/empleados.dat");
			return false;
		}

		System.out.println("Todos los archivos obligatorios encontrados\n");
		return true;
	}

	public static int leerEntero(String mensaje) {
		int numero = 0;
		String input;
		String patronNumero = "\\d+"; // Solo dígitos

		
			input = mensaje;

			if (input.matches(patronNumero)) {
				numero = Integer.parseInt(input);
			} else {
				System.err.println("Por favor, introduzca un valor válido (solo números).");
			}


		return numero;
	}

	public static String leerTexto(String mensaje) {
		String texto;
		String patronLetras = "[a-zA-Z]+";

		
			texto = mensaje;

			if (!texto.matches(patronLetras)) {
				System.err.println("Por favor, introduzca solo letras.");
			}
		

		return texto;
	}

	public static float leerFloat(String mensaje) {
		float numero = 0;
		String input;
		String patronFloat = "\\d+(\\.\\d+)?"; // Digitos con opcional decimal

		
			input = mensaje;

			if (input.matches(patronFloat)) {
				numero = Float.parseFloat(input);
			} else {
				System.err.println("Por favor, introduzca un valor válido (número decimal).");
			}
		

		return numero;
	}

}
