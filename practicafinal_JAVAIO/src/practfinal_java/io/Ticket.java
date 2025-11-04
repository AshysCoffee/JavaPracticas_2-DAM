package practfinal_java.io;

import java.io.Serializable;
import java.util.ArrayList;

public class Ticket implements Serializable{

	private int cod_ticket, cod_empleado;
	private String nombre_empleado;
	private double total;
	ArrayList <LineaTicket> lista_prod;
	
	public Ticket(int cod_ticket, int cod_empleado, String nombre_empleado, double total) {
		super();
		this.cod_ticket = cod_ticket;
		this.cod_empleado = cod_empleado;
		this.nombre_empleado = nombre_empleado;
		this.total = total;
		lista_prod = new ArrayList <>();
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
	
	
	

	@Override
	public String toString() {
		
		return "Número Ticket:" + cod_ticket + "\n——————————————//———————————------------------------\n"
				+"\nEmpleado que ha atendido: "+cod_empleado+"\nNombre del empleado: "+nombre_empleado+
				"CodigoProducto\tProducto\tCantidad\tPrecioUnitario\n"+lista_prod.toString();		
	}
	
	
	
}
