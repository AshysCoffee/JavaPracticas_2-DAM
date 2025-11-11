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

<<<<<<< HEAD
	
	public static void main(String[] args) {
			try {
				
			ControlErrores ce = new ControlErrores();
			
			ce.verificarYCrearDirectorios();
			ce.verificarArchivosObligatorios();
				
			GestorPlantas gp = new GestorPlantas();
			
			gp.cargarPlantaDat();
			gp.cargarPlantasAlta();
		
			
			GestorEmpleados ge = new GestorEmpleados();
			
			
			
		MenuVendedor mn = new MenuVendedor(gp);
		
		mn.mostrarMenu();
		
		} catch (DatosInvalidosException e) {
			e.printStackTrace();
		}
		
	}
	
=======
	//Pruebas unitarias ->

    Planta p1 = (21, "Margarita", "Margarita.png", "Flor comúnen zonas aledañas del norte");

    System.out.println (p1.toString);



>>>>>>> dde921bd497be78295941df6eb8a7d012e80e7ff
}


