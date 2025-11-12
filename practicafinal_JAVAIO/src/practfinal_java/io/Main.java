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
				GestorEmpleados ge = new GestorEmpleados();
				GestorPlantas gp = new GestorPlantas();
				
				ce.verificarYCrearDirectorios();
				ce.verificarArchivosObligatorios();
					
				try {
					gp.crearPlantasDat();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				gp.inicializar();
				
				ge.guardarEmpleadoEnAlta();
				
			MenuVendedor mn = new MenuVendedor(gp);
			
			mn.mostrarMenu();
			
			
			} catch (DatosInvalidosException e) {
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


