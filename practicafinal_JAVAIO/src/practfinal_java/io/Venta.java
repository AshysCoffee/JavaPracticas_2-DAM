package practfinal_java.io;

import java.io.Serializable;
import java.io.File;

import java.util.ArrayList;

import java.time.*;

@SuppressWarnings("serial")
public class Venta implements Serializable{

	private static int ultimoTicket=0;
	private int cod_ticket, cod_empleado;
	private String nombre_empleado;
	private double total;
	private LocalDate fecha;
	ArrayList <LineaTicket> lista_prod;
	ArrayList <Planta> cesta;
	
	public Venta(int cod_empleado, String nombre_empleado) {
		super();
		this.cod_ticket = 0;
		this.cod_empleado = cod_empleado;
		this.nombre_empleado = nombre_empleado;
		this.fecha = LocalDate.now();
		this.total = 0;
		lista_prod = new ArrayList <>();
		cesta = new ArrayList <>();
	}

	public int getCod_ticket() {
		return cod_ticket;
	}

	public void setCod_ticket(int cod_ticket) {
		this.cod_ticket = cod_ticket;
	}

	public int getCod_empleado() {
		return cod_empleado;
	}

	public void setCod_empleado(int cod_empleado) {
		this.cod_empleado = cod_empleado;
	}

	public String getNombre_empleado() {
		return nombre_empleado;
	}

	public void setNombre_empleado(String nombre_empleado) {
		this.nombre_empleado = nombre_empleado;
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
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Planta> getCesta() {
		return cesta;
	}

	public void setCesta(ArrayList<Planta> cesta) {
		this.cesta = cesta;
	}
	
	
/////////////////// METODOS	DE VENTA 
	
	public void inicializarUltimoTicket() {
	    
		File carpetaTickets = new File("TICKETS");
	    
	    if (!carpetaTickets.exists()) { //lo creamos si no existe
	        carpetaTickets.mkdirs();
	        cod_ticket = 0;
	        return;
	    }

	    File[] tickets = carpetaTickets.listFiles(); //listamos todos los archivos
	    int max = 0; 
	    if (tickets != null) {
	        for (File t : tickets) { //recorremos el array y los volvemos todos normales
	            String nombre = t.getName().replace(".txt", "");
	            try {
	                int num = Integer.parseInt(nombre); //Los volvemos numeros normales
	                if (num > max) max = num;
	            } catch (NumberFormatException e) {
	                // Ignorar archivos que no sean tickets
	            }
	        }
	    }
	    cod_ticket = max;
	}

	
//	public int generarNuevoTicket() {
//	    cod_ticket++; // siguiente número
//	    this.numeroTicket = ultimoTicket; // asignarlo a la venta
//	    generarTicketArchivo(); // guarda en carpeta TICKETS
//	    return numeroTicket;
//	}

	public String leerLineas() {
		String s = "";
		for (LineaTicket l : lista_prod) {
			s += (l.toString());
		}
		return s;
	} //Ver si me sirve de algo este metodo xd
	
	
	public void agregarLinea(LineaTicket linea) {
        lista_prod.add(linea);
        this.total += linea.calcularSubtotal();
    }
	
	
//	public void agregarProducto (Producto p) {
//		cesta.add(p);
//	}
	
	
	public void generarTicket () {
		
	}
	
	
	
	@Override
	public String toString() {
		
		return "Número Ticket:" + cod_ticket + "\n——————————————//———————————------------------------\n"
				+"\nEmpleado que ha atendido: "+cod_empleado+"\nNombre del empleado: "+nombre_empleado+"\n"
						+ "Fecha: "+fecha+"\n"+
				"CodigoProducto\tProducto\tCantidad\tPrecioUnitario\n"+leerLineas();		
	}
	
	
	
}
