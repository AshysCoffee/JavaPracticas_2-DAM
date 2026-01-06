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

			input = sc.next();
			opcion = ControlErrores.leerEntero(input);

			switch (opcion) {

			case 1:

				System.out.println(gestor_p.mostrarPlantas());
				break;

			case 2:

				Venta v = new Venta(gestor_p, this.empleado);

				int id_planta = 0;
				int cantidad = 0;

				boolean existePlanta = true;
				boolean hayStock = true;

				do {

					System.out.println("\nCódigo planta (1000 para terminar):");
					input = sc.next();
					id_planta = ControlErrores.leerEntero(input);

					if (id_planta == 1000) {
						break;
					}
					
					if (gestor_p.buscarPlanta(gestor_p.getPlantasAlta(), id_planta) == null) {
						System.err.println("No existe dicha planta");
						existePlanta = false;
						break;
					}

					System.out.println("Cantidad:");
					input = sc.next();
					cantidad = ControlErrores.leerEntero(input);

					if (gestor_p.buscarPlanta(gestor_p.getPlantasAlta(), id_planta).getStock() < cantidad) {
						System.err.println("La cantidad soliciada supera a la existente");
						hayStock = false;
						break;
					}

					v.agregarProducto(id_planta, cantidad);

				} while (id_planta != 1000);

				if (existePlanta && hayStock) {
					System.out.println("Esta es su cesta:===========");
					System.out.println(v.toString());

					System.out.println("¿Desea continuar con la compra? [Y/N]");

					input = sc.next();
					String resp = ControlErrores.leerTexto(input);

					if (resp.equalsIgnoreCase("Y")) {
						v.generarTicket();
						System.out.println("Se genero el ticket correctamente");
					} else if (resp.equalsIgnoreCase("N")) {
						System.out.println("NO se pudo continuar la compra");
					}

				} else {

					System.err.println("Compra interrumpida");
					break;

				}

				break;

			case 3:

				System.out.print("Introduce el número del ticket a buscar: ");
				input = sc.next();
				int num = ControlErrores.leerEntero(input);

				GestorTickets gt = new GestorTickets();
				String contenido = gt.buscarTicketPorNumero(num);

				if (contenido == null) {
					System.err.println("Ticket no encontrado\n");
					break;
				}

				System.out.println(contenido);

				System.out.print("Introduce el ID de la planta a devolver: ");
				input = sc.next();
				int id = ControlErrores.leerEntero(input);

			    String idABuscar = String.valueOf(id); 

			    if (!contenido.contains(idABuscar+"\t\t")) {
			        System.err.println("Error: Esta planta no figura en el ticket seleccionado.");
			        break;
			    }
			   
				
				if (gestor_p.buscarPlanta(gestor_p.getPlantasAlta(), id) == null) {
					System.err.println("No existe dicha planta");
					existePlanta = false;
					break;
				}

				System.out.print("Introduce la cantidad a devolver: ");
				input = sc.next();
				int cantidad_d = ControlErrores.leerEntero(input);

				Planta p = gestor_p.buscarPlanta(getGestor_p().getPlantasAlta(), id);

				if (p != null) {
					ArrayList<String> lineasDevolucion = new ArrayList<>();
					lineasDevolucion
							.add(p.getNombre() + " x" + cantidad_d + " -> -" + p.getPrecio() * cantidad_d + "€");

					gt.agregarDevolucionATicket(num, lineasDevolucion);
					
					int nuevoStock = p.getStock() + cantidad_d;

					gestor_p.actualizarStockDat(p.getCodigo(), nuevoStock);

					System.out.println("Devolución procesada correctamente.");

				} else {
					
					System.out.println("Planta no encontrada.");
				}
				break;

			
				
			case 0:
				System.out.println("Cerrando sesión. ¡Hasta luego!");
				break;

			default:
				System.err.println("No existe esa opción, por favor eliga alguna de las siguientes");
				break;

			}
		} while (opcion != 0);

		sc.close();

	}
}
