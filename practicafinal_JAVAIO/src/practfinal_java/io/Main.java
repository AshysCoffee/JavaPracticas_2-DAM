package practfinal_java.io;

import java.io.IOException;

public class Main {

	//	Empleado e = gestor.validarLogin(id, pwd);
	//
	//	if (e != null) {
	//	    switch (e.getCargo()) {
	//	        case GESTOR:
	//	            new MenuGestor(e, gestor).mostrarMenu();
	//	            break;
	//	        case VENDEDOR:
	//	            new MenuVendedor(e).mostrarMenu();
	//	            break;
	//	    }
	//	} else {
	//	    System.out.println("Credenciales incorrectas");
	//	}


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

	//Pruebas unitarias ->

//	public static void main(String[] args) {
//
//		try {
//			
//		
//			
//			
//		}catch (Exception e){
//			e.printStackTrace();
//		}
//
//		
//		
//	}
}


