package practfinal_java.io;

import java.io.File;

public class ControlErrores {
	
	//MODIFICAR LOS METODOS Y DOCUMENTAR DIOS YA NO PUEDO AAAAAA
	
	public void verificarYCrearDirectorios() {
		
	    System.out.println("Verificando estructura de directorios...");
	    
	    String[] carpetasNecesarias = { "Plantas","Empleados","Empleados/Bajas","Tickets","Devoluciones" };
	    
	    boolean existente = true;
	    
	    for (String ruta : carpetasNecesarias) {
	        File carpeta = new File(ruta);
	        
	        if (!carpeta.exists()) {
	            System.out.println("Creando carpeta '" + ruta);
	            if (carpeta.mkdirs()) {
	                System.out.println("Carpeta '" + ruta + "' creada correctamente");
	            } else {
	                System.out.println("Error al crear carpeta '" + ruta + "'");
	                existente = false;
	            }
	        } else {
	            System.out.println("Carpeta '" + ruta + "' encontrada");
	        }
	    }
	    
	    if (existente) {
	        System.out.println("Estructura de directorios verificada correctamente\n");
	    } else {
	        System.out.println("Hubo problemas al crear la estructura de directorios\n");
	    }
	}
	
	public boolean verificarArchivosObligatorios() {
	    System.out.println("Verificando archivos obligatorios...");
	    
	    boolean todosExisten = true;
	    
	    // Archivos que DEBEN existir
	    String[] archivosObligatorios = {
	        "PLANTAS/plantas.xml",
	        "PLANTAS/plantas.dat",
	        "EMPLEADOS/empleados.dat"
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
	
	
}
