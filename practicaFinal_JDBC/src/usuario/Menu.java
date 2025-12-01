package usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import gestionPrograma.Cambios;
import gestionPrograma.Consultas;
import gestionPrograma.Inventario;
import gestionPrograma.RRHH;
import gestionPrograma.Ventas;
import modelosBases.ConexionBD;
import modelosBases.ControlErrores;

public class Menu {

	private Connection conn;

	public Menu() {
		try {
			ConexionBD conexionBD = new ConexionBD();
			this.conn = conexionBD.conectarBBDD();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Error crítico: No se pudo conectar a la base de datos.");
		}
	}

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
			System.out.println("4. Gestión de Cambios");
			System.out.println("5. Consultas de la Tienda");
			System.out.println("0. Salir");
			System.out.print("Seleccione una opción: ");

			String input = sc.next();
			opcion = ControlErrores.leerEntero(input);

			switch (opcion) {
			case 1:
				mostrarMenuJuguetes();
				break;
			case 2:
				mostrarMenuEmpleados();
				break;
			case 3:
				mostrarMenuVentas();
				break;
			case 4:
				mostrarMenuCambios();
				break;
			case 5:
				mostrarMenuConsultas();
				break;
			case 0:
				
				try {
					conn.close();
					System.out.println("Saliendo...");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				break;
				
			default:
				System.out.println("Opción inválida");
				break;
			}

		} while (opcion != 0);
	}

	public void mostrarMenuJuguetes() {

		int opcion = -1;

		do {

			System.out.println("=== MENU JUGUETES ===");
			System.out.println("1. Crear Juguete");
			System.out.println("2. Buscar Juguete");
			System.out.println("3. Listar Juguetes");
			System.out.println("4. Modificar precio de un Juguete");
			System.out.println("5. Modificar stock de un Juguete");
			System.out.println("6. Eliminar Juguete");
			System.out.println("0. Volver");

			String input = sc.next();
			opcion = ControlErrores.leerEntero(input);

			Inventario inv = new Inventario(conn);

			switch (opcion) {
			case 1:

				System.out.println("Por favor ingrese los siguientes datos:");
				
				System.out.print("ID: ");

				input = sc.next();
				int id = ControlErrores.leerEntero(input);
				sc.nextLine();
				
				System.out.print("Nombre: ");

				input = sc.next();
				String nombre = ControlErrores.leerTexto(input);
				sc.nextLine();
				
				System.out.print("Descripción:");
				input = sc.next();
				String descripcion = ControlErrores.leerTexto(input);
				sc.nextLine();

				System.out.print("Precio: ");

				input = sc.next();
				double precio = ControlErrores.leerDouble(input);
				sc.nextLine();
				
				System.out.print("Stock: ");
				
				input = sc.next();
				int stock = ControlErrores.leerEntero(input);
				sc.nextLine();
				
				boolean creado = inv.crearJuguete(id, nombre, descripcion, precio, stock);

				if (creado) {
					System.out.println("Se creo de forma correcta!");
				} else {
					System.out.println("Hubo un error en la creación, revise los valores introducidos en el sistema.");
				}

				break;

			case 2:

				System.out.println("Introduzca el ID del juguete a buscar: ");
				input = sc.next();
				int id_juguete = ControlErrores.leerEntero(input);

				inv.buscarJuguete(id_juguete).toString();

				break;

			case 3:

				inv.listarJuguetes();
				break;

			case 4:

				System.out.print("Por favor, introduzca el ID del juguete que desee modificar su precio: ");
				input = sc.next();
				id = ControlErrores.leerEntero(input);

				System.out.println("Ahora el precio que le desee establecer: ");
				input = sc.next();
				precio = ControlErrores.leerDouble(input);

				boolean modificado = inv.modificarPrecio(id, precio);

				if (modificado) {
					System.out.println("Se ha modificiado el precio.");
				} else {
					System.out.println("No se pudo modificar el precio por los datos ingresados");
				}

				break;

			case 5:

				System.out.print("Por favor, introduzca el ID del juguete que desee modificar su precio: ");
				input = sc.next();
				id = ControlErrores.leerEntero(input);

				System.out.println("Ahora el precio que le desee establecer: ");
				input = sc.next();
				stock = ControlErrores.leerEntero(input);

				modificado = inv.modificarPrecio(id, stock);

				if (modificado) {
					System.out.println("Se ha modificiado el precio.");
				} else {
					System.out.println("No se pudo modificar el precio por los datos ingresados");
				}

				break;

			case 6:

				System.out.print("Por favor, introduzca el ID del juguete que desee modificar su precio: ");
				input = sc.next();
				id = ControlErrores.leerEntero(input);

				boolean eliminado = inv.eliminarJuguete(id);

				if (eliminado) {
					System.out.println("Juguete eliminado correctamente.");
				} else {
					System.out.println("No se pudo eliminar el juguete. Verifique que el ID sea correcto.");
				}

				break;

			case 0:
				System.out.println("Saliendo...");
				
				break;

			default:
				System.out.println("Opción inválida");
				break;
			}

		} while (opcion != 0);
	}

	public void mostrarMenuEmpleados() {

		int opcion = -1;
		do {

			System.out.println("================================");
			System.out.println("       MENÚ DE EMPLEADOS        ");
			System.out.println("================================");
			System.out.println("1. Añadir empleado");
			System.out.println("2. Buscar empleado por ID");
			System.out.println("3. Listar empleados");
			System.out.println("4. Eliminar empleado");
			System.out.println("0. Volver");
			System.out.print("Seleccione una opción: ");

			String input = sc.next();
			opcion = ControlErrores.leerEntero(input);

			RRHH recursosHumanos = new RRHH (conn);
			
			switch (opcion) {
			case 1:
				System.out.println("Por favor ingrese los siguientes datos:");
				System.out.print("Nombre: ");

				input = sc.next();
				String nombre = ControlErrores.leerTexto(input);

				System.out.print("Cargo (Jefe o Cajero):");

				input = sc.next();
				String cargo = ControlErrores.leerTexto(input);

				boolean creado = recursosHumanos.crearEmpleado(nombre, cargo);

				if (creado) {
					System.out.println("Se creo de forma correcta!");
				} else {
					System.out.println("Hubo un error en la creación, revise los valores introducidos en el sistema.");
				}
				
				
				break;
				
			case 2:
				
				System.out.println("Introduzca el ID del empleado a buscar: ");
				input = sc.next();
				int id_empleado = ControlErrores.leerEntero(input);

				recursosHumanos.buscarEmpleado(id_empleado).toString();
				
				break;
				
			case 3:
				
				recursosHumanos.listarEmpleados();
				
				break;
				
			case 4:
				System.out.println("Introduzca el ID del empleado a eliminar: ");
				input = sc.next();
				id_empleado = ControlErrores.leerEntero(input);

				boolean borrar = recursosHumanos.eliminarEmpleado(id_empleado);

				if (borrar) {
					System.out.println("Se ha borrado todo el empleado");
				} else {
					System.out.println("Hubo un error en la eliminacion, revise los valores en el sistema.");
				}
				
				break;
			case 0:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción inválida");
				break;
			}

		} while (opcion != 0);

	}

	public void mostrarMenuVentas() {

		int opcion = -1;
		do {

			System.out.println("================================");
			System.out.println("         MENÚ DE VENTAS         ");
			System.out.println("================================");
			System.out.println("1. Realizar venta");
			System.out.println("2. Consultar ventas por Mes");
	        System.out.println("3. Consultar ventas por Empleado");
			System.out.println("4. Productos más vendidos (Top 5)");
			System.out.println("5. Empleados que más venden");
			System.out.println("0. Volver");
			System.out.print("Seleccione una opción: ");

			String input = sc.next();
			opcion = ControlErrores.leerEntero(input);

			Ventas ventas = new Ventas(conn);
			
			switch (opcion) {
			
			case 1:
				
				System.out.println("Introduzca los datos de la venta:");
				
				System.out.print("Importe: ");
				input = sc.next();
				double precio = ControlErrores.leerDouble(input);
				
				System.out.print("Tipo de pago (Efectivo / Tajeta / Paypal): ");
				input = sc.next();
				String tipoPago = ControlErrores.leerTexto(input);
				
				System.out.print("ID del empleado: ");
				input = sc.next();
				int id_empleado = ControlErrores.leerEntero(input);
				
				System.out.print("ID del juguete: ");
				input = sc.next();
				int id_juguete = ControlErrores.leerEntero(input);

				
				boolean vendido = ventas.crearVenta(tipoPago, precio, id_empleado, id_juguete);
				

				if (vendido) {
					System.out.println("Se ha registrado la venta de forma exitosa!");
				}else {
					System.out.println("Hubo un error en el registro, intentelo de nuevo.");
				}
				
				
				break;
			case 2:
				
				System.out.println("Por favor, introduzca el mes que desea consultar (1-12): ");
				
				input = sc.next();
				int mes = ControlErrores.leerEntero(input);
				
				ventas.ventasPorMes(mes);
				
				break;
			case 3:
				System.out.println("Por favor, introduzca el ID del empleado: ");

				input = sc.next();
				int id = ControlErrores.leerEntero(input);

				ventas.ventasPorEmpleado(id);
				break;
			case 4:
				ventas.Top5Productos();
				break;
			case 5:
				ventas.EmpleadoMasProduc();
				break;
			case 0:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción inválida");
				break;

			}

		} while (opcion != 0);

	}

	public void mostrarMenuCambios() {

		int opcion = -1;
		do {

			System.out.println("================================");
			System.out.println("        MENÚ DE CAMBIOS         ");
			System.out.println("================================");
			System.out.println("1. Registrar cambio");
			System.out.println("2. Ver todos los cambios");
			System.out.println("3. Buscar cambio por ID");
			System.out.println("4. Buscar cambios hechos por empleado");
			System.out.println("0. Volver");
			System.out.print("Seleccione una opción: ");

			String input = sc.next();
			opcion = ControlErrores.leerEntero(input);
			
			Cambios cambios = new Cambios(conn);

			switch (opcion) {
			case 1:
				
				System.out.print("ID de cambio: ");
				input = sc.next();
				int id_cambio = ControlErrores.leerEntero(input);
				
				System.out.print("Motivo:");
				input = sc.next();
				String motivo = ControlErrores.leerTexto(input);
				
				System.out.print("ID del stand del juguete a devolver: ");
				input = sc.next();
				int stand_id_original = ControlErrores.leerEntero(input);
				
				System.out.print("ID de la zona del juguete a devolver: ");
				input = sc.next();
				int zona_id_original = ControlErrores.leerEntero(input);
				
				System.out.print("ID del juguete a devolver: ");
				input = sc.next();
				int juguete_id_original = ControlErrores.leerEntero(input);
				
				System.out.print("ID Stand del nuevo juguete: ");
				input = sc.next();
				int stand_id_nuevo = ControlErrores.leerEntero(input);
				
				System.out.print("ID Zona del nuevo juguete: ");
				input = sc.next();
				int zona_id_nuevo = ControlErrores.leerEntero(input);
				
				System.out.print("ID del nuevo juguete: ");
				input = sc.next();
				int juguete_id_nuevo = ControlErrores.leerEntero(input);
				
				System.out.print("ID del Empleado: ");
				input = sc.next();
				int empleado_id = ControlErrores.leerEntero(input);
				
				
				boolean registrado = cambios.ingresarCambio(id_cambio ,motivo, stand_id_original, zona_id_original, juguete_id_original, stand_id_nuevo, zona_id_nuevo, juguete_id_nuevo, empleado_id);
				
				if(registrado) {
					System.out.println("Se pudo crear y guardar el cambio!!");
				}else {
					System.out.println("No se pudo registrar el cambio.");
				}
				
				break;
			case 2:
				cambios.listasTodosCambios();
				break;
				
			case 3:
				
				System.out.print("Por favor, introduzca el ID del cambio: ");
				input = sc.next();
				id_cambio = ControlErrores.leerEntero(input);
				
				cambios.buscarCambio(id_cambio);
				
				break;
			case 4:
				
				System.out.print("Por favor, introduzca el ID del empleado: ");
				input = sc.next();
				int id = ControlErrores.leerEntero(input);
				
				cambios.listasCambiosPerEmpleados(id);
				break;
	
			case 0:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción inválida");
				break;
			}

		} while (opcion != 0);

	}

	public void mostrarMenuConsultas() {

		int opcion = -1;
		do {

			System.out.println("================================");
			System.out.println("     MENÚ DE CONSULTAS TIENDA   ");
			System.out.println("================================");
			System.out.println("1. Juguetes de menor a mayor precio");
			System.out.println("2. Juguetes de mayor a menor precio");
			System.out.println("3. Juguetes por rango de precio");
			System.out.println("0. Volver");
			System.out.print("Seleccione una opción: ");

			String input = sc.next();
			opcion = ControlErrores.leerEntero(input);

			Consultas consultas = new Consultas(conn); 
			
			switch (opcion) {
			case 1:
				consultas.JuguetesDeMenosAMas();
				break;
			case 2:
				consultas.JuguetesDeMasAMenos();
				break;
			case 3:
				
				System.out.println("Introduzca el mínimo de la busqueda: ");
				input = sc.next();
				int min = ControlErrores.leerEntero(input);

				System.out.println("Introduzca el máximo de la busqueda: ");
				input = sc.next();
				int max = ControlErrores.leerEntero(input);

				consultas.JuguetesRango(min, max);
				
				break;
			case 0:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción inválida");
				break;
			}

		} while (opcion != 0);

	}

}
