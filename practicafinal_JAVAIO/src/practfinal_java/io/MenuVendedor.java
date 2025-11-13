package practfinal_java.io;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuVendedor {

	private Empleado empleado;
	private GestorPlantas gestor_p;
	private Venta ventas;
	private Devolucion devoluciones;         
	private ControlErrores ce;
	
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
		String patron_numero = "\\d";
		String patron_letras = "[a-zA-Z]";
		Scanner sc = new Scanner(System.in);
		int opcion = 0;

		System.out.println("Bienvenido al sistema");		

		do {


			System.out.println("=== MENÚ VENDEDOR ===");
			System.out.println("1. Visualizar catálogo de plantas\n"
					+ "2. Generar venta\n"
					+ "3. Generar devolución\n"
					+ "0. Cerrar sesión");
			System.out.println("Elige una opción: ");



			if (String.valueOf(opcion).matches(patron_numero)) {
				opcion = sc.nextInt();

			}else {
				System.err.println("Por favor, introduzca un valor válido");
			}

			switch (opcion) {

			case 1:

				System.out.println(gestor_p.mostrarPlantas()); 
				break;

			case 2:


				Venta v = new Venta(empleado.getNombre(),empleado.getId_empleado());
				
				int id_planta = 0;
				int cantidad = 0;
				
				do {
				  System.out.println("Introduce el codigo de la planta que desea y la cantidad deseada.\nCuando termine de seleccionar introduzca 200 en cada apartado");
				  System.out.print("Codigo de la planta:");
					
				  input = sc.next();
				  id_planta = ControlErrores.leerEntero(input);
				  
				  System.out.print("Cantidad deseada:");
				  input = sc.next();
				  cantidad = ControlErrores.leerEntero(input);
				  
				v.agregarProducto(id_planta, cantidad);

				}while (id_planta!=200 && cantidad!=200);


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
			    
			    int num = 0;
			    
			    if (String.valueOf(num).matches(patron_numero)) {
					num = sc.nextInt();
				}else {
					System.err.println("Por favor, introduzca un valor válido");
				}
			    

			    GestorTickets gt = new GestorTickets();
			    String contenido = gt.buscarTicketPorNumero(num);

			    if (contenido == null) {
			    	System.out.println("Ticket no encontrado");
			    }
			    System.out.println(contenido);

			    int id = 0;
			    
			    System.out.print("Introduce el ID de la planta a devolver: ");
			   
			    if (String.valueOf(id).matches(patron_numero)) {
					id = sc.nextInt();
				}else{
					System.err.println("Por favor, introduzca un valor válido");
				}

			    System.out.print("Introduce la cantidad a devolver: ");
			    
				int cantidad_d = sc.nextInt();

			    Planta p = gestor_p.buscarPlanta(getGestor_p().getPlantasAlta(),id);

			    if (p != null) {
			        ArrayList<String> lineasDevolucion = new ArrayList<>();
			        lineasDevolucion.add(p.getNombre() + " x" + cantidad_d + " -> -" + p.getPrecio() * cantidad_d + "€");

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
				break;

			} 
		}while (opcion != 0);

		sc.close();

	}
}
