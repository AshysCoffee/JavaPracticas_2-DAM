package practfinal_java.io;

public class Main {

	public static void main(String[] args) {

		try {

			GestorPlantas gp = new GestorPlantas();
			gp.inicializar();


			GestorEmpleados ge = new GestorEmpleados();
			ge.inicializarGestores();


			ControlErrores ce = new ControlErrores();
			ce.verificarYCrearDirectorios();
			if (!ce.verificarArchivosObligatorios()) {
				System.out.println("Faltan archivos obligatorios. Terminando ejecución.");
			}

			ge.autenticarInteractivo(gp, 3);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}


