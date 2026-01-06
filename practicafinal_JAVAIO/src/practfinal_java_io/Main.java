package practfinal_java_io;

public class Main {

	public static void main(String[] args) {

		try {

			GestorPlantas gp = new GestorPlantas();
			gp.inicializar();


			GestorEmpleados ge = new GestorEmpleados();
			ge.inicializar();


			ControlErrores ce = new ControlErrores();
			ce.verificarYCrearDirectorios();
			if (!ce.verificarArchivosObligatorios()) {
				System.out.println("Faltan archivos obligatorios. Terminando ejecución.");
			}

			
			ge.autenticarInteractivo(gp, 3);
			  

		} catch (Exception e) {
			System.out.println("Error inesperado: " + e.getMessage());
		}

	}

}


