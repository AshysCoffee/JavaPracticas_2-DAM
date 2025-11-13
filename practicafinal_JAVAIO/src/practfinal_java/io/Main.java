package practfinal_java.io;

public class Main {

		public static void main(String[] args) {
			try {

				ControlErrores ce = new ControlErrores();
				ce.verificarYCrearDirectorios();
				if (!ce.verificarArchivosObligatorios()) {
					System.out.println("Faltan archivos obligatorios. Terminando ejecución.");
					return;
				}

				GestorPlantas gp = new GestorPlantas();

				gp.inicializar();

				gp.cargarPlantasAlta();
				gp.cargarPlantasBaja();
				gp.cargarPlantaDat();

				GestorEmpleados gestor = new GestorEmpleados();
				
				gestor.inicializarGestores();
				
				gestor.autenticarInteractivo(gp, 3);


			} catch (Exception e) {
				e.printStackTrace();
			}


			
		}

}


