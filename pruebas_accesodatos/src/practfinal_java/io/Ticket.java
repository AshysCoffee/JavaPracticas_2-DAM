package practfinal_java.io;

import java.util.ArrayList;

public class Ticket {

	private int cod_ticket, cod_empleado;
	private String nombre_empleado;
	private float total;
	ArrayList <LineaTicket> lista_prod;
	
	public Ticket(int cod_ticket, int cod_empleado, String nombre_empleado, float total) {
		super();
		this.cod_ticket = cod_ticket;
		this.cod_empleado = cod_empleado;
		this.nombre_empleado = nombre_empleado;
		this.total = total;
		lista_prod = null;
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

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		/*return "Codigo del Ticket:" + cod_ticket + "\nCódigo Empleado:" + cod_empleado + "\nEmpleado: "
				+ nombre_empleado + "\nTotal=" + total;*/
		
		return "Número Ticket:" + cod_ticket + "\n——————————————//———————————------------------------\n"
				+"\nEmpleado que ha atendido: "+cod_empleado+"\nNombre del empleado: "+nombre_empleado+
				"CodigoProducto\tProducto\tCantidad\tPrecioUnitario\n"+lista_prod;		
	}
	
	
	
}
