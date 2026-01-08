package modelosBases;

public class ControlErrores {

	//////// METODOS DE CONTROL DE ERRORES

	public static int leerEntero(String mensaje) throws DatosInvalidosException {
		int numero = -1;
		String input;
		String patronNumero = "^\\d+$"; // Solo dígitos

		input = mensaje;

		if (input.matches(patronNumero)) {
			numero = Integer.parseInt(input);
		} else {
			throw new DatosInvalidosException("Por favor, introduzca un valor válido (número entero).");
		}

		return numero;
	}

	public static String leerTexto(String mensaje) throws DatosInvalidosException {
		String texto;
		String patronLetras = "^[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ\\s]+$";

		texto = mensaje.trim();

		if (!texto.matches(patronLetras)) {
			throw new DatosInvalidosException("Por favor, introduzca un valor válido (solo letras).");
		}

		return texto;
	}

	public static double leerDouble(String mensaje) throws DatosInvalidosException  {
		double numero = 0.0;
		String input;
		String patronDouble = "\\d+(\\.\\d+)?"; // Números decimales

		input = mensaje;

		if (input.matches(patronDouble)) {
			numero = Double.parseDouble(input);
		} else {
			throw new DatosInvalidosException("Por favor, introduzca un valor válido (número decimal).");
		}

		return numero;
	}

}
