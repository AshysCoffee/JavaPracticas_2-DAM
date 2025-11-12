package practfinal_java.io;

import java.io.File;
import java.util.regex.Pattern;


public class ControlErrores {
	
	//MODIFICAR LOS METODOS Y DOCUMENTAR DIOS YA NO PUEDO AAAAAA

	public void verificarYCrearDirectorios() {

		System.out.println("Verificando estructura de directorios...");

		String[] carpetasNecesarias = { "PLANTAS","EMPLEADOS","EMPLEADOS/BAJAS","TICKETS","DEVOLUCIONES" };

		boolean existente = true;

		for (String ruta : carpetasNecesarias) {
			File carpeta = new File(ruta);

			try{  

				if (!carpeta.exists()) {
					System.out.println("Creando carpeta '" + ruta);
					carpeta.mkdirs();
					System.out.println("Carpeta '" + ruta + "' creada correctamente");
				}	        	

			}catch (Exception e) {
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
	
	
	public boolean soloNumeros(int numero) {
		
			String patron = "\\d";
			String datos = String.valueOf(numero);
			
			if (datos.matches(patron)) {
				return true;
			}
			
		return false;	
	}
	
	
	public boolean soloLetras(String palabra) {
		
		String patron = "[a-zA-Z]";
		String datos = palabra;
		
		if (datos.matches(patron)) {
			return true;
		}
		
	return false;	
}
	
	
}
