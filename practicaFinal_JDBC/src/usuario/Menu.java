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
import modelosBases.DatosInvalidosException;
import modelosBases.Juguete;
import modelosBases.Venta;

public class Menu {

	private Connection conn;

	Inventario inv;
	RRHH recursosHumanos;
	Ventas ventas;
	Cambios cambios;
	Consultas consultas;

	public Menu() {
		try {
			ConexionBD conexionBD = new ConexionBD();
			this.conn = conexionBD.conectarBBDD();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error crítico: No se pudo conectar a la base de datos.");
		}
		this.inv = new Inventario(conn);
		this.recursosHumanos = new RRHH(conn);
		this.ventas = new Ventas(conn);
		this.cambios = new Cambios(conn);
		this.consultas = new Consultas(conn);
	}

	Scanner sc = new Scanner(System.in);

	public void mostrarMenuPrincipal() {

		int opcion = -1;

		do {
			
			try {
				
			
			System.out.println("================================");
			System.out.println("          MENÚ PRINCIPAL        ");
			System.out.println("================================");
			System.out.println("1. Gestión de Juguetes");
			System.out.println("2. Gestión de Empleados");
			System.out.println("3. Gestión de Ventas");
			System.out.println("4. Gestión de Cambios");
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
			case 0:

				try {
					conn.close();
					System.out.println("Saliendo...");
				} catch (SQLException e) {
					System.out.println("Error al cerrar la conexión: " + e.getMessage());
				}

				break;

			default:
				System.out.println("Opción inválida");
				break;
			}

			} catch (DatosInvalidosException e) {
				System.err.println("Error: " + e.getMessage());
			}
		} while (opcion != 0);
	}

	public void mostrarMenuJuguetes(){

		int opcion = -1;

		do {

			try {
			
			System.out.println("=== MENU JUGUETES ===");
			System.out.println("1. Crear Juguete");
			System.out.println("2. Buscar Juguete");
			System.out.println("3. Listar Juguetes");
			System.out.println("4. Modificar precio de un Juguete");
			System.out.println("5. Modificar stock de un Juguete");
			System.out.println("6. Eliminar Juguete");
			System.out.println("7. Mover mercancía entre Stands");
			System.out.println("0. Volver");
			System.out.print("Seleccione una opción: ");

			String input = sc.next();
			opcion = ControlErrores.leerEntero(input);

			switch (opcion) {
			case 1:

				System.out.println("Por favor ingrese los siguientes datos:");

				sc.nextLine();

				System.out.print("Nombre: ");
				input = sc.nextLine();
				String nombre = ControlErrores.leerTexto(input);

				System.out.print("Descripción:");
				input = sc.nextLine();
				String descripcion = ControlErrores.leerTexto(input);

				System.out.print("Precio: ");
				input = sc.next();
				double precio = ControlErrores.leerDouble(input);
				sc.nextLine();

				System.out.print("Stock: ");
				input = sc.next();
				int stock = ControlErrores.leerEntero(input);
				sc.nextLine();

				System.out.print("Categoría (ej. Vehículos, Muñecas): ");
				input = sc.next();
				String categoria = ControlErrores.leerTexto(input);
				sc.nextLine();

				System.out.print("ID de la Zona donde se ubicará: ");
				input = sc.next();
				int zona = ControlErrores.leerEntero(input);
				sc.nextLine();

				System.out.print("ID del Stand donde se ubicará: ");
				input = sc.next();
				int stand = ControlErrores.leerEntero(input);
				sc.nextLine();

				boolean creado = inv.crearJuguete(nombre, descripcion, precio, stock, categoria, zona, stand);

				if (creado) {
					System.out.println("Se creo de forma correcta!");
				} else {
					System.out.println("Hubo un error en la creación, revise los valores introducidos en el sistema.");
				}

				break;

			case 2:

				mostrarMenuConsultas();

				break;

			case 3:

				inv.listarJuguetes();
				break;

			case 4:

				System.out.print("ID del juguete que desee modificar su precio: ");
				input = sc.next();
				int id = ControlErrores.leerEntero(input);

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

				System.out.print("ID del juguete que desee modificar su stock: ");
				input = sc.next();
				id = ControlErrores.leerEntero(input);

				System.out.print("Ahora el stock que le desee establecer: ");
				input = sc.next();
				stock = ControlErrores.leerEntero(input);

				modificado = inv.modificarStock(id, stock);

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

			case 7:

				System.out.print("ID del Juguete a mover: ");
				int idMove = ControlErrores.leerEntero(sc.next());

				System.out.print("Cantidad a mover: ");
				int cantMove = ControlErrores.leerEntero(sc.next());

				System.out.println("--- DESDE (ORIGEN) ---");
				System.out.print("ID Stand Origen: ");
				int stOrig = ControlErrores.leerEntero(sc.next());
				System.out.print("ID Zona Origen: ");
				int zOrig = ControlErrores.leerEntero(sc.next());

				System.out.println("--- HACIA (DESTINO) ---");
				System.out.print("ID Stand Destino: ");
				int stDest = ControlErrores.leerEntero(sc.next());
				System.out.print("ID Zona Destino: ");
				int zDest = ControlErrores.leerEntero(sc.next());

				inv.moverMercancia(idMove, cantMove, stOrig, zOrig, stDest, zDest);
				break;

			case 0:
				System.out.println("Saliendo...");

				break;

			default:
				System.out.println("Opción inválida");
				break;
			}
			
		} catch (DatosInvalidosException e) {
			System.err.println("Error: " + e.getMessage());
		}

		} while (opcion != 0);
	}

	public void mostrarMenuEmpleados() {

		int opcion = -1;
		do {

			try {
			System.out.println("================================");
			System.out.println("       MENÚ DE EMPLEADOS        ");
			System.out.println("================================");
			System.out.println("1. Añadir empleado");
			System.out.println("2. Listar empleados");
			System.out.println("3. Eliminar empleado");
			System.out.println("4. Modificar empleado");
			System.out.println("5. Ver ventas por empleado y mes");
			System.out.println("0. Volver");
			System.out.print("Seleccione una opción: ");

			String input = sc.next();
			opcion = ControlErrores.leerEntero(input);

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

				recursosHumanos.listarEmpleados();

				break;

			case 3:
				System.out.println("Introduzca el ID del empleado a eliminar: ");
				input = sc.next();
				int id_empleado = ControlErrores.leerEntero(input);

				boolean borrar = recursosHumanos.eliminarEmpleado(id_empleado);

				if (borrar) {
					System.out.println("Se ha borrado todo el empleado");
				} else {
					System.out.println("Hubo un error en la eliminacion, revise los valores en el sistema.");
				}

				break;

			case 4:

				System.out.println("Introduzca el ID del empleado a modificar:");
				input = sc.next();
				id_empleado = ControlErrores.leerEntero(input);

				System.out.print("Nuevo nombre: ");
				input = sc.next();
				nombre = ControlErrores.leerTexto(input);

				System.out.print("Nuevo Cargo (Jefe o Cajero):");
				input = sc.next();
				cargo = ControlErrores.leerTexto(input);

				boolean modificado = recursosHumanos.actualizarEmpleado(id_empleado, nombre, cargo);

				if (modificado) {
					System.out.println("Se ha modificado todo el empleado");
				} else {
					System.out.println("Hubo un error en la modificacion, revise los valores en el sistema.");
				}

				break;

			case 5:

				System.out.println("Introduzca el ID del empleado a buscar ventas: ");

				System.out.print("ID Empleado: ");
				int idEmpleado = ControlErrores.leerEntero(sc.next());
				System.out.print("Mes (1-12): ");
				int m = ControlErrores.leerEntero(sc.next());
				ventas.ventasPorEmpleadoYMes(idEmpleado, m);
				break;

			case 0:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción inválida");
				break;
			}

			} catch (DatosInvalidosException e) {
				System.err.println("Error: " + e.getMessage());
			}
			
		} while (opcion != 0);

	}

	public void mostrarMenuVentas() {

		int opcion = -1;
		do {

			try {
				
			
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

			switch (opcion) {

			case 1:

				System.out.println("=== NUEVA COMPRA (CARRITO) ===");

				System.out.print("ID del Empleado que atiende: ");
				int idEmp = ControlErrores.leerEntero(sc.next());

				System.out.print("Nombre Cliente (Opcional, enter para saltar): ");
				sc.nextLine();
				String clienteNombre = sc.nextLine();

				if (clienteNombre.trim().isEmpty()) {
					clienteNombre = null;
				}

				System.out.print("Tipo Pago (EFECTIVO/TARJETA/PAYPAL): ");
				String pago = ControlErrores.leerTexto(sc.next());

				boolean seguirComprando = true;
				double totalCompra = 0;

				while (seguirComprando) {

					System.out.println("\n--- Añadir producto al carrito ---");
					System.out.print("ID del Juguete: ");
					int idJug = ControlErrores.leerEntero(sc.next());

					System.out.print("Cantidad: ");
					int cant = ControlErrores.leerEntero(sc.next());

					Juguete j = inv.buscarJuguete(idJug);
					double importeLinea = 0;

					if (j != null) {
						importeLinea = j.getPrecio() * cant;
						System.out.println("Precio unitario: " + j.getPrecio() + " | Subtotal: " + importeLinea);
					} else {
						System.out.print("No se encontró precio. Introduzca importe manual: ");
						importeLinea = ControlErrores.leerDouble(sc.next());
					}

					// Llamamos al nuevo método crearVenta con cantidad y cliente
					boolean exito = ventas.crearVenta(pago, importeLinea, idEmp, idJug, cant, clienteNombre);

					if (exito) {
						totalCompra += importeLinea;
						System.out.println(">> Producto añadido correctamente.");
					}

					System.out.print("\n¿Añadir otro producto? (s/n): ");
					String resp = ControlErrores.leerTexto(sc.next());
					if (resp.equalsIgnoreCase("n")) {
						seguirComprando = false;
					}
				}

				System.out.println("=== COMPRA FINALIZADA ===");
				System.out.println("Total abonado: " + totalCompra + " €");
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
			
			} catch (DatosInvalidosException e) {
				System.err.println("Error: " + e.getMessage());
			}

		} while (opcion != 0);

	}

	public void mostrarMenuCambios(){

		int opcion = -1;
		do {

			try {
			
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

			    System.out.println("\n--- NUEVA DEVOLUCIÓN ---");
			    
			    System.out.print("Introduzca el ID de la VENTA (Ticket): ");
			    int idVenta = ControlErrores.leerEntero(sc.next());

			    Venta ventaOriginal = ventas.buscarVentasPorId(idVenta);
			    
			    if (ventaOriginal == null) {
			        System.err.println("Error: No existe ninguna venta con ese ID.");
			        break;
			    }

			    System.out.println("Venta encontrada: Juguete ID " + ventaOriginal.getId_juguete() 
			                     + " (Comprado en Stand " + ventaOriginal.getId_stand() + ")");

			    System.out.println("\n--- PRODUCTO A LLEVARSE (CAMBIO) ---");
			    
			    System.out.print("ID del Nuevo Juguete: ");
			    int idJugueteNuevo = ControlErrores.leerEntero(sc.next());

			    System.out.print("ID Stand del Nuevo Juguete: ");
			    int idStandNuevo = ControlErrores.leerEntero(sc.next());

			    System.out.print("ID Zona del Nuevo Juguete: ");
			    int idZonaNuevo = ControlErrores.leerEntero(sc.next());

			    System.out.print("Motivo del cambio: ");
			    sc.nextLine();
			    String motivo = ControlErrores.leerTexto(sc.nextLine());

			    
			    boolean registrado = cambios.ingresarCambio(
			            motivo, 
			            ventaOriginal.getId_stand(),
			            ventaOriginal.getId_zona(),
			            ventaOriginal.getId_juguete(),
			            idStandNuevo, 
			            idZonaNuevo, 
			            idJugueteNuevo, 
			            ventaOriginal.getId_empleado()
			    );

			    if (registrado) {
			        System.out.println("¡Cambio realizado con éxito!");
			    } else {
			        System.out.println("Error al registrar el cambio.");
			    }
			    break;
			    
			case 2:
				cambios.listasTodosCambios();
				break;

			case 3:

				System.out.print("Por favor, introduzca el ID del cambio: ");
				input = sc.next();
				int id_cambio = ControlErrores.leerEntero(input);

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

			} catch (DatosInvalidosException e) {
				System.err.println("Error: " + e.getMessage());
			}
			
		} while (opcion != 0);

	}

	public void mostrarMenuConsultas(){

		int opcion = -1;
		do {

			try {
				
			
			System.out.println("================================");
			System.out.println("     MENÚ DE CONSULTAS TIENDA   ");
			System.out.println("================================");
			System.out.println("1. Juguetes de menor a mayor precio");
			System.out.println("2. Juguetes de mayor a menor precio");
			System.out.println("3. Juguetes por rango de precio");
			System.out.println("4. Buscar juguetes por categoría");
			System.out.println("5. Buscar stock y posición de un juguete");
			System.out.println("0. Volver");
			System.out.print("Seleccione una opción: ");

			String input = sc.next();
			opcion = ControlErrores.leerEntero(input);

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

			case 4:
				System.out.println("Introduzca la categoría a buscar: ");
				input = sc.next();
				String categoria = ControlErrores.leerTexto(input);

				inv.buscarPorCategoria(categoria);
				break;

			case 5:
				System.out.println("Introduzca el ID del juguete a buscar: ");
				input = sc.next();
				int id = ControlErrores.leerEntero(input);
				
				System.out.println("--- INFORMACIÓN DEL JUGUETE ---");
				inv.buscarJuguete(id);
				System.out.println("\n--- POSICIÓN EN TIENDA ---");
				consultas.posicionJuguete(id);
				
				break;
				
			case 0:
				System.out.println("Saliendo...");
				break;
				
			default:
				System.out.println("Opción inválida");
				break;
			}

			} catch (DatosInvalidosException e) {
				System.err.println("Error: " + e.getMessage());
			}
			
		} while (opcion != 0);

	}

}
