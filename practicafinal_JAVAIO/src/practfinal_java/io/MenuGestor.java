package practfinal_java.io;

import java.util.Scanner;

public class MenuGestor {

	private Empleado empleado;
	private GestorEmpleados gestor_e;
	private GestorPlantas gestor_p;
	private ControlErrores ce;

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

	///////// METODOS DEL MENU <---- los hacemos aparte para hacer codigo más limpio

	// public void altaPlanta(); //Opcion 1
	//
	// public void bajaPlanta(int codigo); //Opcion 2
	//
	// public void modificarPlanta(int codigo); //Opcion 3
	//
	// public void altaEmpleado(); //Opcion 4
	//
	// public void bajaEmpleado(int id); //Opcion 5
	//
	// public void recontratarEmpleado(int id); //Opcion 6
	//
	// public void mostrarEstadisticas(); //Opcion 7

	public void modificarPlanta(int codigo) {
		Scanner sc = new Scanner(System.in);
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
					sc.nextLine();
					input = sc.nextLine();

					opcion = ControlErrores.leerEntero(input);

					switch (opcion) {
						case 1:
							System.out.print("Introduce el nuevo precio: ");
							sc.nextLine();
							input = sc.nextLine();

							float nuevoPrecio = ControlErrores.leerFloat(input);

							if (nuevoPrecio >= 0) {
								try {
									p.setPrecio(nuevoPrecio);
								} catch (DatosInvalidosException e) {
									e.printStackTrace();
									System.out.println("Error al actualizar el precio: " + e.getMessage());
								}
								System.out.println("Precio actualizado correctamente.");
							} else {
								System.err.println("El precio no puede ser negativo.");
							}
							break;

						case 2:
							System.out.print("Introduce el nuevo stock: ");
							sc.nextLine();
							input = sc.nextLine();

							int nuevoStock = ControlErrores.leerEntero(input);

							if (nuevoStock >= 0) {
								try {
									p.setStock(nuevoStock);
								} catch (DatosInvalidosException e) {
									e.printStackTrace();
									System.out.println("Error al actualizar el stock: " + e.getMessage());
								}
								System.out.println("Stock actualizado correctamente.");
							} else {
								System.err.println("El stock no puede ser negativo.");
							}
							break;

						case 3:
							System.out.print("Introduce el nuevo precio: ");

							sc.nextLine();
							input = sc.nextLine();

							float precioAmbos = ControlErrores.leerFloat(input);
							System.out.print("Introduce el nuevo stock: ");

							sc.nextLine();
							input = sc.nextLine();

							int stockAmbos = ControlErrores.leerEntero(input);

							if (precioAmbos >= 0 && stockAmbos >= 0) {
								try {
									p.setPrecio(precioAmbos);
									p.setStock(stockAmbos);
								} catch (DatosInvalidosException e) {
									e.printStackTrace();
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

	// LO HACEMOS UN METODO PARA QUE CUANDO EL USUARIO PASE LA
	// VALIDACION LE LLEVE DIRECTAMENTE AL MENU Y LO PUEDA EJECUTAR DESDE AHI

	public void mostrarMenu() {

		String input;

		Scanner sc = new Scanner(System.in);
		int opcion;

		do {

			System.out.println("Bienvenido " + empleado.getNombre() + "\n");
			System.out.println("=== MENÚ GESTOR ===\n"
					+ "1. Alta de plantas\n"
					+ "2. Baja de plantas\n"
					+ "3. Modificar planta\n"
					+ "4. Alta de empleados\n"
					+ "5. Baja de empleados\n"
					+ "6. Recontratar empleado\n"
					+ "7. Consultar estadísticas\n"
					+ "0. Cerrar sesión");

			System.out.println("Elige una opción: ");

			sc.nextLine();
			input = sc.nextLine();

			opcion = ControlErrores.leerEntero(input);

			switch (opcion) {

				case 1:

					System.out.println("Por favor introduzca los siguientes datos:\n");
					System.out.println("ID del producto:");
					sc.nextLine();
					input = sc.nextLine();
					int id = ControlErrores.leerEntero(input);

					System.out.println("Nombre de la planta:");
					input = sc.nextLine();
					String nombre = ControlErrores.leerTexto(input);

					System.out.println("Foto de la planta:");
					input = sc.nextLine();
					String foto = ControlErrores.leerTexto(input);

					System.out.println("Descripción de la planta:");
					input = sc.next();
					String descripcion = ControlErrores.leerTexto(input);

					System.out.println("Stock:");
					sc.nextLine();
					input = sc.nextLine();
					int stock = ControlErrores.leerEntero(input);

					sc.nextLine();

					System.out.println("Precio:");

					sc.nextLine();
					input = sc.nextLine();
					float precio = ControlErrores.leerFloat(input);

					gestor_p.dardeAltaPlanta(id, nombre, foto, descripcion, stock, precio);
					System.out.println("Se ha podido crear la planta correctamente");

					break;

				case 2:

					System.out.print("Introduzca el ID del producto que quiere dar de baja:");
					input = sc.next(); // Leemos como String

					int id_baja = ControlErrores.leerEntero(input);

					gestor_p.darDeBajaPlanta(id_baja);

					break;

				case 3:

					System.out.println("Introduzca el ID del producto que quiere modificar:");

					input = sc.next(); // Leemos como String
					int codigo = ControlErrores.leerEntero(input);

					modificarPlanta(codigo);

					break;

				case 4:

					System.out.println("Dando de alta a un nuevo empleado...");

					System.out.print("ID del empleado: ");
					sc.nextLine();
					input = sc.nextLine();
					int id_emp = ControlErrores.leerEntero(input);

					System.out.print("Nombre del empleado: ");
					input = sc.nextLine();
					String nombre_emp = ControlErrores.leerTexto(input);


					System.out.print("Contraseña del empleado: ");
					String contraseña = sc.nextLine();

					System.out.print("Cargo del empleado (1. VENDEDOR, 2. ENCARGADO): ");
					sc.nextLine();
					input = sc.nextLine();
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

				case 5:

					System.out.print("Introduzca el ID del empleado que quiere dar de baja:");
					input = sc.next(); 
					int id_baja_emp = ControlErrores.leerEntero(input);

					gestor_e.darBajaEmpleado(id_baja_emp);

					break;

				case 6:

					System.out.print("Introduzca el ID del empleado que quiere recontratar:");
					input = sc.next();
					int id_recontratar = ControlErrores.leerEntero(input);
					gestor_e.recuperarEmpleado(id_recontratar);

					break;

				case 7:


					gestor_p.mostrarEstadisticas();
					break;

				default:
					System.out.println("Opción no válida. Por favor, elige otra opción.");
					break;

			}
		} while (opcion != 0);

		sc.close();
	}

}
