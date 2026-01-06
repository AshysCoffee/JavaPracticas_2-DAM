package practfinal_java_io;

import java.util.Scanner;

public class MenuGestor {

	private Empleado empleado;
	private GestorEmpleados gestor_e;
	private GestorPlantas gestor_p;
	private ControlErrores ce;

	Scanner sc = new Scanner(System.in);

	public MenuGestor(Empleado empleado, GestorEmpleados gestor_e, GestorPlantas gestor_p) {
		super();
		this.empleado = empleado;
		this.gestor_e = gestor_e;
		this.gestor_p = gestor_p;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public GestorEmpleados getGestor_e() {
		return gestor_e;
	}

	public void setGestor_e(GestorEmpleados gestor_e) {
		this.gestor_e = gestor_e;
	}

	public GestorPlantas getGestor_p() {
		return gestor_p;
	}

	public void setGestor_p(GestorPlantas gestor_p) {
		this.gestor_p = gestor_p;
	}

	public ControlErrores getCe() {
		return ce;
	}

	public void setCe(ControlErrores ce) {
		this.ce = ce;
	}

	public void modificarPlanta(int codigo) throws DatosInvalidosException {

		boolean encontrada = false;
		String input;

		for (Planta p : gestor_p.getPlantasAlta()) {
			if (p.getCodigo() == codigo) {
				encontrada = true;

				int opcion;
				do {
					System.out.println("\n--- MODIFICAR PLANTA ---");
					System.out.println("1. Modificar precio");
					System.out.println("2. Modificar stock");
					System.out.println("3. Modificar ambos");
					System.out.println("0. Volver al menú principal");
					System.out.print("Elige una opción: ");
					input = sc.next();
					opcion = ControlErrores.leerEntero(input);

					switch (opcion) {

					case 1:
						System.out.print("Introduce el nuevo precio: ");

						input = sc.next();
						float nuevoPrecio = ControlErrores.leerFloat(input);

						if (nuevoPrecio >= 0) {

							try {
								p.setPrecio(nuevoPrecio);
								gestor_p.actualizarPrecioDat(codigo, nuevoPrecio);

							} catch (DatosInvalidosException e) {

								System.out.println("Error al actualizar el precio: " + e.getMessage());
							}
							System.out.println("Precio actualizado correctamente.");
						} else {
							System.err.println("El precio no puede ser negativo.");
						}
						break;

					case 2:
						System.out.print("Introduce el nuevo stock: ");
						input = sc.next();

						int nuevoStock = ControlErrores.leerEntero(input);

						if (nuevoStock >= 0) {
							try {
								p.setStock(nuevoStock);
								gestor_p.actualizarStockDat(codigo, nuevoStock);
							} catch (DatosInvalidosException e) {

								System.out.println("Error al actualizar el stock: " + e.getMessage());
							}
							System.out.println("Stock actualizado correctamente.");
						} else {
							System.err.println("El stock no puede ser negativo.");
						}
						break;

					case 3:
						System.out.print("Introduce el nuevo precio: ");

						input = sc.next();

						float precioAmbos = ControlErrores.leerFloat(input);
						System.out.print("Introduce el nuevo stock: ");

						input = sc.next();
						int stockAmbos = ControlErrores.leerEntero(input);

						if (precioAmbos >= 0 && stockAmbos >= 0) {
							try {
								p.setPrecio(precioAmbos);
								p.setStock(stockAmbos);

								gestor_p.actualizarPrecioDat(codigo, precioAmbos);
								gestor_p.actualizarStockDat(codigo, stockAmbos);

							} catch (DatosInvalidosException e) {

								System.out.println("Error al actualizar los valores: " + e.getMessage());
							}
							System.out.println("Precio y stock actualizados correctamente.");
						} else {
							System.err.println("Los valores no pueden ser negativos.");
						}
						break;

					case 0:
						System.out.println("Volviendo al menú principal...");
						break;

					default:
						System.out.println("Opción no válida.");
						break;
					}

				} while (opcion != 0);

				break;
			}
		}

		if (!encontrada) {
			System.out.println("No se encontró ninguna planta con ese código.");
		}
	}

	public void mostrarOpcionesPlantas() throws DatosInvalidosException {
		int opcion = -1;

		do {

			System.out.println("Bienvenido " + empleado.getNombre());
			System.out.println("=== MENÚ GESTOR ===\n" + "1. Alta de plantas\n" + "2. Baja de plantas\n"
					+ "3. Modificar planta\n" + "4. Rescatar planta\n" + "0. Salir");

			System.out.println("Elige una opción: ");

			String input = sc.next();
			opcion = ControlErrores.leerEntero(input);

			switch (opcion) {

			case 1:

				boolean valido = true;

				try {

					System.out.println("Dando de alta una nueva planta...");

					System.out.println("Nombre de la planta:");
					input = sc.next();
					String nombre = ControlErrores.leerTexto(input);

					System.out.println("Foto de la planta:");
					input = sc.next();
					String foto = ControlErrores.leerTexto(input);

					System.out.println("Descripción de la planta:");
					input = sc.next();
					String descripcion = ControlErrores.leerTexto(input);

					System.out.println("Stock:");
					input = sc.next();
					int stock = ControlErrores.leerEntero(input);

					System.out.println("Precio:");
					input = sc.next();
					float precio = ControlErrores.leerFloat(input);

					if (valido) {
						gestor_p.dardeAltaPlanta(nombre, foto, descripcion, stock, precio);
						System.out.println("Se ha podido crear la planta correctamente");
					} else {
						System.out.println("No se ha podido crear la planta debido a errores en los datos.");
						break;
					}

				} catch (DatosInvalidosException e) {
					System.out.println("Error al dar de alta la planta: " + e.getMessage());
					valido = false;
				}
				break;

			case 2:

				System.out.print("Introduzca el ID del producto que quiere dar de baja:");
				input = sc.next();

				int id_baja = ControlErrores.leerEntero(input);

				gestor_p.darDeBajaPlanta(id_baja);

				break;

			case 3:

				System.out.println("Introduzca el ID del producto que quiere modificar:");
				input = sc.next();
				int codigo = ControlErrores.leerEntero(input);

				modificarPlanta(codigo);

				break;

			case 4:

				System.out.println("Introduzca el ID del producto que quiere rescatar:");
				input = sc.next();
				codigo = ControlErrores.leerEntero(input);

				System.out.println("Precio asignado a la planta");
				input = sc.next();
				float precio = ControlErrores.leerFloat(input);

				System.out.println("Introduzca el ID del producto que quiere modificar:");
				input = sc.next();
				int stock = ControlErrores.leerEntero(input);

				gestor_p.recuperarPlanta(codigo, precio, stock);

				break;

			case 0:
				System.out.println("Saliendo...");
				break;

			default:
				System.out.println("Opción no válida. Por favor, elige otra opción.");
				break;

			}
		} while (opcion != 0);
	}

	public void mostrarOpcionesEmpleado() throws DatosInvalidosException {

		int opcion = -1;

		do {

			System.out.println("Bienvenido " + empleado.getNombre());
			System.out.println("=== MENÚ GESTOR ===\n" + "1. Alta de empleados\n" + "2. Baja de empleados\n"
					+ "3. Recontratar empleado\n" + "0. Salir");

			System.out.println("Elige una opción: ");

			String input = sc.next();
			opcion = ControlErrores.leerEntero(input);

			switch (opcion) {

			case 1:

				System.out.println("Dando de alta a un nuevo empleado...");

				System.out.print("ID del empleado: ");
				input = sc.next();
				int id_emp = ControlErrores.leerEntero(input);

				System.out.print("Nombre del empleado: ");
				input = sc.next();
				String nombre_emp = ControlErrores.leerTexto(input);

				System.out.print("Contraseña del empleado: ");
				String contraseña = sc.next();

				System.out.print("Cargo del empleado (1. VENDEDOR, 2. ENCARGADO): ");
				input = sc.next();
				int cargoInt = ControlErrores.leerEntero(input);

				Cargo cargo;
				if (cargoInt == 1) {
					cargo = Cargo.VENDEDOR;
				} else if (cargoInt == 2) {
					cargo = Cargo.ENCARGADO;
				} else {
					System.out.println("Cargo no válido. Operación cancelada.");
					break;
				}

				gestor_e.darAltaEmpleado(id_emp, nombre_emp, contraseña, cargo);

				System.out.println("Empleado dado de alta correctamente.");

				break;

			case 2:

				System.out.print("Introduzca el ID del empleado que quiere dar de baja:");
				input = sc.next();
				int id_baja_emp = ControlErrores.leerEntero(input);

				gestor_e.darBajaEmpleado(id_baja_emp);

				break;

			case 3:

				System.out.print("Introduzca el ID del empleado que quiere recontratar:");
				input = sc.next();
				int id_recontratar = ControlErrores.leerEntero(input);
				gestor_e.recuperarEmpleado(id_recontratar);

				break;

			case 0:
				System.out.println("Saliendo...");
				break;

			default:
				System.out.println("Opción no válida. Por favor, elige otra opción.");
				break;

			}
		} while (opcion != 0);
	}

	public void mostrarMenu() throws DatosInvalidosException {

		String input;

		Scanner sc = new Scanner(System.in);
		int opcion = -1;

		do {

			System.out.println("Bienvenido " + empleado.getNombre());
			System.out.println("=== MENÚ GESTOR ===\n" + "1. Gestionar plantas\n" + "2. Gestionar empleados\n"
					+ "3. Consultar estadísticas\n" + "4. Mostrar plantas\n" + "0. Cerrar sesión");

			System.out.println("Elige una opción: ");

			input = sc.next();
			opcion = ControlErrores.leerEntero(input);

			switch (opcion) {

			case 1:

				mostrarOpcionesPlantas();
				break;
				
			case 2:

				mostrarOpcionesEmpleado();
				break;

			case 3:

				gestor_p.calcularEstadisticasAvanzadas();
				break;

			case 4:

				System.out.println("Plantas disponibles:");
				System.out.println(gestor_p.mostrarPlantas());

				System.out.println("Plantas NO disponibles:");
				System.out.println(gestor_p.mostrarPlantasBaja());
				break;

			case 0:
				System.out.println("Cerrando sesión...");
				break;

			default:
				System.out.println("Opción no válida. Por favor, elige otra opción.");
				break;

			}
		} while (opcion != 0);

		sc.close();
	}

}
