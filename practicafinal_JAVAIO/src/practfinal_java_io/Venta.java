package practfinal_java_io;

import java.io.Serializable;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.time.*;

@SuppressWarnings("serial")
public class Venta implements Serializable {

	private static int ultimoTicket = 1;
	private Empleado empleado;
	private double total;
	private LocalDate fecha;
	private GestorPlantas gestor;
	private int cod_ticket ;
	private ArrayList<LineaTicket> lista_prod;
	private ArrayList<Planta> cesta;

	public Venta(GestorPlantas gestor, Empleado empleado) {
		this.gestor = gestor;
		this.empleado = empleado;
		this.cod_ticket = ultimoTicket++;
		this.fecha = LocalDate.now();
		this.total = 0;
		lista_prod = new ArrayList<>();
		cesta = new ArrayList<>();
	}


	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ArrayList<LineaTicket> getLista_prod() {
		return lista_prod;
	}

	public void setLista_prod(ArrayList<LineaTicket> lista_prod) {
		this.lista_prod = lista_prod;
	}

	public ArrayList<Planta> getCesta() {
		return cesta;
	}

	public void setCesta(ArrayList<Planta> cesta) {
		this.cesta = cesta;
	}

	public GestorPlantas getGestor() {
		return gestor;
	}

	public void setGestor(GestorPlantas gestor) {
		this.gestor = gestor;
	}

	/////////////////// METODOS DE VENTA

	///// METODOS DE INICIALIZACION

	public void inicializarUltimoTicket() {

		File carpetaTickets = new File("TICKETS");

		if (!carpetaTickets.exists()) { // lo creamos si no existe
			carpetaTickets.mkdirs();
			int cod_ticket = 0;
			return;
		}

		File[] tickets = carpetaTickets.listFiles(); // listamos todos los archivos
		int max = 0;
		if (tickets != null) {
			for (File t : tickets) { // recorremos el array y los volvemos todos string
				String nombre = t.getName().replace(".txt", "");
				try {
					int num = Integer.parseInt(nombre); // Los volvemos numeros normales
					if (num > max)
						max = num; // si el num es mayor que max, max se asigna ese valor
				} catch (NumberFormatException e) {
					e.printStackTrace();
					System.out.println("Error al leer el ticket: " + e.getMessage());
					// Ignorar archivos que no sean tickets
				}
			}

//	        Este se ejecuta normalmente al inicio del programa,
//	        y su trabajo es leer el último número de ticket generado desde un archivo
		}
		ultimoTicket = max;
	} // PROBARLO++ ---- LEE EL ULTIMO NUMERO GUARDADO

	public int generarNuevoTicket() {
	    ultimoTicket++; 
	    this.cod_ticket = ultimoTicket;
	    return cod_ticket;
	}

	///// METODOS DE ESPECIFICOS

	public String leerLineas() {
		String s = "";
		for (LineaTicket l : lista_prod) {
			s += (l.toString());
		}
		return s;
	} // SOLO SIRVE PARA EL TOSTRING NATURAL

	public double calcularTotal() {

		for (Planta p : cesta) {
			total += p.getPrecio();
		}
		return total;
	} // PROBARLO++

	public LineaTicket buscarLinea(int id) {

		LineaTicket linea = null;

		for (LineaTicket l : lista_prod) {
			if (l.getPlanta().getCodigo() == id) {
				linea = l;
			}
		}

		return linea;
	} // PROBARLO

//////////// METODOS DE LINEAS

	public void agregarLinea(LineaTicket linea) {
		lista_prod.add(linea);
		this.total += linea.calcularSubtotal();
	} // PROBARLO++

	public void eliminarLinea(LineaTicket linea) {
		lista_prod.remove(linea);
		this.total -= linea.calcularSubtotal();
	} // PROBARLO++


	
/////////// METODOS DE ARRAYLISTS

	public void agregarProducto(int id, int cantidad) {

		Planta p = gestor.buscarPlanta(gestor.getPlantasAlta(), id);

		if (p == null || cantidad <= 0 || p.getStock() < 1) {
			System.err.println("Error: planta nula o cantidad inválida");
			return;
		}

		if (p.getStock() < cantidad) {
			System.err.println("Error: no hay stock suficiente");
			return;
		}

		if (p != null) {
			cesta.add(p);
			agregarLinea(new LineaTicket(cantidad, p));

		}
		
		if (p.getStock()==0) {
			gestor.darDeBajaPlanta(p.getCodigo());
		}

	} // PROBARLO++

	public void eliminarProducto(int id) {

		LineaTicket lineaAEliminar = null;

		for (LineaTicket l : lista_prod) {
			if (l.getPlanta().getCodigo() == id) {
				lineaAEliminar = l;
				break;
			}
		}

		if (lineaAEliminar != null) {

			cesta.removeIf(p -> p.getCodigo() == id); // Eliminamos todas las unidades que encontremos
			eliminarLinea(lineaAEliminar);// Quita la línea y resta el subtotal del total

			try {
				lineaAEliminar.getPlanta()
						.setStock(lineaAEliminar.getPlanta().getStock() + lineaAEliminar.getCantidad());
			} catch (DatosInvalidosException e) {
				e.printStackTrace();
				System.out.println("Error al actualizar stock: " + e.getMessage());
			}
			gestor.actualizarStockDat(id, lineaAEliminar.getPlanta().getStock());

			System.out.println("Producto con codigo " + id + " eliminado del ticket.");
		} else {
			System.out.println("No se encontro el producto con codigo " + id + " en el ticket.");
		}
	} // PROBARLO++

	///// METODOS DE LECTURA Y ESCRITURA

	public void generarTicket() {
		try {
	
			File carpeta = new File("TICKETS");
			if (!carpeta.exists()) {
				carpeta.mkdirs();
			}
			
			int numeroTicket = generarNuevoTicket();
			
			File f = new File("TICKETS/" + numeroTicket + ".txt");

			try (BufferedWriter buffer_w = new BufferedWriter(new FileWriter(f))) {

				buffer_w.write("===== TICKET DE VENTA Nº " + numeroTicket + " =====\n");
				buffer_w.write("Fecha: " + java.time.LocalDate.now() + "\n\n");
				buffer_w.write("Empleado que ha atendido: " + empleado.getId_empleado() + "\n");
				buffer_w.write("Nombre del empleado: " + empleado.getNombre() + "\n\n");
				buffer_w.write("CódigoProducto\tProducto\tCantidad\tPrecioUnitario\n");

				// Escribimos cada línea de producto
				for (LineaTicket l : lista_prod) {
					buffer_w.write(l.toString() + "\n");
				}

				buffer_w.write("\n------------------------------------\n");
				buffer_w.write("TOTAL: " + total + " €\n");
				buffer_w.write("====================================\n");

				System.out.println("Ticket " + numeroTicket + " guardado correctamente en /TICKETS");

				for (LineaTicket l : lista_prod) {
				    Planta p = l.getPlanta();
				    int cantidad = l.getCantidad();

				    int nuevoStock = (p.getStock() - cantidad);
				    
				    if (nuevoStock < 0) {
				        throw new DatosInvalidosException("Stock no puede ser negativo");
				    }else{
				    	p.setStock(nuevoStock);
				    }
				    
				    gestor.actualizarStockDat(p.getCodigo(), p.getStock());
				}
				
			}
		} catch (IOException | DatosInvalidosException e) {
			System.out.println("Error al guardar ticket: " + e.getMessage());
		}

	} // PROBARLO++

	public void leerTicket(int id) {

		try {

			File carpeta = new File("TICKETS");
			if (!carpeta.exists()) {
				carpeta.mkdirs();
			}

			File f = new File("TICKETS/" + id + ".txt");

			BufferedReader buffer_r = new BufferedReader(new FileReader(f));
			String linea;

			while ((linea = buffer_r.readLine()) != null) {
				System.out.println(linea);
			}

			buffer_r.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error al leer ticket: " + e.getMessage());

		}

	}

	public void buscarTicketPorNumero(int numTicket) {
		try {
			// 1.️ Carpeta donde están los tickets
			File carpeta = new File("TICKETS");
			if (!carpeta.exists()) {
				System.out.println("La carpeta TICKETS no existe todavía.");
				return;
			}

			// 2️. Archivo del ticket que queremos buscar
			File archivoTicket = new File(carpeta, numTicket + ".txt");

			if (!archivoTicket.exists()) {
				System.out.println("No se encontró el ticket Nº " + numTicket);
				return;
			}

			// 3️. Leer el contenido línea a línea
			System.out.println("\nMostrando contenido del ticket Nº " + numTicket + ":\n");

			try (BufferedReader lector = new BufferedReader(new FileReader(archivoTicket))) {
				String linea;
				while ((linea = lector.readLine()) != null) {
					System.out.println(linea);
				}
			}

			System.out.println("\nTicket leído correctamente.\n");
			return;

		} catch (IOException e) {
			System.out.println("Error al leer el ticket: " + e.getMessage());
		}

	}

	@Override
	public String toString() {

		return "Número Ticket:" + cod_ticket + "\n——————————————//———————————------------------------\n"
				+ "\nEmpleado que ha atendido: " + empleado.getId_empleado() + "\nNombre del empleado: "
				+ empleado.getNombre() + "\n" + "Fecha: " + fecha
				+ "\nCodigoProducto\tProducto\tCantidad\tPrecioUnitario\n" + leerLineas() + "\n"
				+ "-------------------------------\nTotal: " + total;

	}

}
