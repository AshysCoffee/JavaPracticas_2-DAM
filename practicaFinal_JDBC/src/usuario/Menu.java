package usuario;

import java.util.Scanner;

import modelosBases.ControlErrores;

public class Menu {
	
	Scanner sc = new Scanner(System.in);
	
	public void mostrarMenuPrincipal() {
		
		int opcion = -1;
	    
	    do {
	    	System.out.println("================================");
	    	System.out.println("          MENÚ PRINCIPAL        ");
	    	System.out.println("================================");
	    	System.out.println("1. Gestión de Juguetes");
	    	System.out.println("2. Gestión de Empleados");
	    	System.out.println("3. Gestión de Ventas");
	    	System.out.println("4. Consultas de la Tienda");
	    	System.out.println("5. Gestión de Cambios");
	    	System.out.println("0. Salir");
	    	System.out.print("Seleccione una opción: ");


	    	String input = sc.next();
	        opcion = ControlErrores.leerEntero(input);

	        switch(opcion) {
	            case 1: mostrarMenuJuguetes();
	            case 2: mostrarMenuVentas();
	            case 3: mostrarMenuCambios();
	            case 4: mostrarMenuConsultas();
	            case 5: System.out.println("Saliendo...");
	            default: System.out.println("Opción inválida");
	        }

	    } while (opcion != 5);
	}

	
	public void mostrarMenuJuguetes() {
	    int opcion = -1;
	    do {
	        System.out.println("=== MENU JUGUETES ===");
	        System.out.println("1. Crear Juguete");
	        System.out.println("2. Buscar Juguete");
	        System.out.println("3. Listar Juguetes");
	        System.out.println("4. Volver");

	        String input = sc.next();
	        opcion = ControlErrores.leerEntero(input);
	        
	        switch(opcion) {
//	            case 1 -> crearJuguete();
//	            case 2 -> buscarJuguete();
//	            case 3 -> listarJuguetes();
//	            case 4 -> modificarJuguete();
//	            case 5 -> eliminarJuguete();
//	            case 6 -> {} // volver
	            default -> System.out.println("Opción inválida");
	        }

	    } while (opcion != 4);
	}

	public void mostrarMenuVentas() {

		System.out.println("================================");
		System.out.println("         MENÚ DE VENTAS         ");
		System.out.println("================================");
		System.out.println("1. Realizar venta");
		System.out.println("2. Realizar devolución");
		System.out.println("3. Productos más vendidos (Top 5)");
		System.out.println("4. Empleados que más venden");
		System.out.println("0. Volver");
		System.out.print("Seleccione una opción: ");

	}
	
	public void mostrarMenuCambios() {

		System.out.println("================================");
		System.out.println("        MENÚ DE CAMBIOS         ");
		System.out.println("================================");
		System.out.println("1. Registrar cambio");
		System.out.println("2. Ver todos los cambios");
		System.out.println("3. Buscar cambio por ID");
		System.out.println("0. Volver");
		System.out.print("Seleccione una opción: ");


	}
	
	
	public void mostrarMenuConsultas() {

		System.out.println("================================");
		System.out.println("     MENÚ DE CONSULTAS TIENDA   ");
		System.out.println("================================");
		System.out.println("1. Juguetes disponibles en un stand");
		System.out.println("2. Ventas realizadas en un mes");
		System.out.println("3. Ventas realizadas por un empleado en un mes");
		System.out.println("4. Cambios realizados por los empleados");
		System.out.println("5. Listar productos ordenados por precio");
		System.out.println("0. Volver");
		System.out.print("Seleccione una opción: ");

	}
}
