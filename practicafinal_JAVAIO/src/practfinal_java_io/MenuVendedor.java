package practfinal_java_io;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuVendedor {

	private Empleado empleado;
	private GestorPlantas gestor_p;
	private Venta ventas;
	private Devolucion devoluciones;

	public MenuVendedor(GestorPlantas gestor_p, Empleado empleado) {
		super();
		this.gestor_p = gestor_p;
		this.empleado = empleado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public GestorPlantas getGestor_p() {
		return gestor_p;
	}

	public void setGestor_p(GestorPlantas gestor_p) {
		this.gestor_p = gestor_p;
	}

	public Venta getVentas() {
		return ventas;
	}

	public void setVentas(Venta ventas) {
		this.ventas = ventas;
	}

	public Devolucion getDevoluciones() {
		return devoluciones;
	}

	public void setDevoluciones(Devolucion devoluciones) {
		this.devoluciones = devoluciones;
	}

	///////////////// MOSTRAR MENU

	public void mostrarMenu() throws DatosInvalidosException {

		String input;
		Scanner sc = new Scanner(System.in);

		System.out.println("Bienvenido al sistema, " + empleado.getNombre() + "\n");

		int opcion;

		do {

			System.out.println("=== MENÚ VENDEDOR ===");
			System.out.println("1. Visualizar catálogo de plantas\n" + "2. Generar venta\n" + "3. Generar devolución\n"
					+ "0. Cerrar sesión");
			System.out.println("Elige una opción: ");

			input = sc.nextLine();
			opcion = ControlErrores.leerEntero(input);

			switch (opcion) {

			case 1:

				System.out.println(gestor_p.mostrarPlantas());
				break;

			case 2:

				Venta v = new Venta(gestor_p, this.empleado);

				int id_planta = 0;
				int cantidad = 0;

				do {
					
					System.out.println("\nCódigo planta (1000 para terminar):");
					input = sc.nextLine();
					id_planta = ControlErrores.leerEntero(input);

					System.out.println("Cantidad (1000 para terminar):");
					input = sc.nextLine();
					cantidad = ControlErrores.leerEntero(input);

					// Si el usuario quiere terminar la compra
					if (id_planta == 1000 && cantidad == 1000) {
						System.out.println("Cesta cerrada.");
						break; // <--- este break está permitido, porque rompe solo el bucle principal
					}

					v.agregarProducto(id_planta, cantidad);

				} while (true);

				System.out.println("Esta es su cesta:===========");
				System.out.println(v.toString());

				System.out.println("¿Desea continuar con la compra? [Y/N]");

				input = sc.nextLine();
				String resp = ControlErrores.leerTexto(input);

				if (resp.equalsIgnoreCase("Y")) {
					v.generarTicket();
					System.out.println("Se genero el ticket correctamente");
				} else if (resp.equalsIgnoreCase("N")) {
					System.out.println("NO se pudo continuar la compra");
				}

				break;

			case 3:

				System.out.print("Introduce el número del ticket a buscar: ");
				input = sc.nextLine();
				int num = ControlErrores.leerEntero(input);

				GestorTickets gt = new GestorTickets();
				String contenido = gt.buscarTicketPorNumero(num);

				if (contenido == null) {
					System.out.println("Ticket no encontrado");
				}
				System.out.println(contenido);

				System.out.print("Introduce el ID de la planta a devolver: ");
				input = sc.nextLine();
				int id = ControlErrores.leerEntero(input);

				System.out.print("Introduce la cantidad a devolver: ");
				input = sc.nextLine();
				int cantidad_d = ControlErrores.leerEntero(input);

				Planta p = gestor_p.buscarPlanta(getGestor_p().getPlantasAlta(), id);

				if (p != null) {
					ArrayList<String> lineasDevolucion = new ArrayList<>();
					lineasDevolucion
							.add(p.getNombre() + " x" + cantidad_d + " -> -" + p.getPrecio() * cantidad_d + "€");

					// Añadimos al archivo existente:
					gt.agregarDevolucionATicket(num, lineasDevolucion);

					// Actualizamos el stock (si quieres reflejarlo en el sistema):
					p.setStock(p.getStock() + cantidad_d);
					System.out.println("Devolución procesada correctamente.");
					
				} else {
					System.out.println("Planta no encontrada.");
				}
				break;

			default:
				System.out.println("No existe esa opción, por favor eliga alguna de las siguientes");

			}
		} while (opcion != 0);

		sc.close();

	}
}
