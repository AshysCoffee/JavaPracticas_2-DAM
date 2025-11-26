package modelosBases;

public class ControlErrores {

////////METODOS DE CONTROL DE ERRORES	
	
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

public static double leerDouble(String mensaje) {
	double numero = 0;
	String input;
	String patronDouble = "\\d+(\\.\\d+)?"; // Números decimales

	
		input = mensaje;

		if (input.matches(patronDouble)) {
			numero = Double.parseDouble(input);
		} else {
			System.err.println("Por favor, introduzca un valor válido (número decimal).");
		}
	

	return numero;
}


	
}
