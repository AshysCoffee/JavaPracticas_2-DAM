package practfinal_java.io;

import java.io.IOException;
import java.util.Scanner;

public class MenuVendedor {

	private Empleado empleado;
	private GestorPlantas gestor_p;
	private Venta ventas;
	private Devolucion devoluciones;
	
	
	
	public MenuVendedor(Empleado empleado) {
		super();
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
	
//	public void mostrarCatalogo(); //Opcion 1
//	
//	
//	//Opcion 2
//	public void generarVenta();            // coordina todo el proceso
//	public void agregarACompra();          // añade planta y cantidad a la cesta
//	public void confirmarVenta();          // genera el ticket y actualiza stock
//	public void generarTicket(Venta v);    // escribe el ticket en /TICKETS
//	
//	
//	//Opcion 3
//	public void generarDevolucion();
//	private void buscarTicket(int numeroTicket);
//	private void procesarDevolucion(Ticket t);
	
	

	public void mostrarMenu() throws DatosInvalidosException {
		
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {

			System.out.println("Bienvenido " + empleado.getNombre());
			System.out.println("=== MENÚ VENDEDOR ===");
			System.out.println("1. Visualizar catálogo de plantas\n"
					+ "2. Generar venta\n"
					+ "3. Generar devolución\n"
					+ "0. Cerrar sesión");
			System.out.println("Elige una opción: ");
			System.out.println("0. Salir");


			opcion = sc.nextInt();

			switch (opcion) {

			case 1:
				System.out.println(gestor_p.mostrarPlantas());
				
				break;

			case 2:

				break;

			case 3:

				break;


			default:
				System.out.println("No existe esa opción, por favor eliga alguna de las siguientes");
				break;

			} 
		}while (opcion != 0);

		sc.close();

	}
}
