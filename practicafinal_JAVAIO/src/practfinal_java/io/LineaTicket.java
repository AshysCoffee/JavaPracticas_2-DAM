package practfinal_java.io;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LineaTicket implements Serializable{
	
	private int cantidad;
	private Planta planta;
	
	public LineaTicket(int cantidad, Planta planta) {
		super();
		this.cantidad = cantidad;
		this.planta = planta;
	}	
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public Planta getPlanta() {
		return planta;
	}
	public void setPlanta(Planta planta) {
		this.planta = planta;
	}


	public float calcularSubtotal() {
	    return cantidad * planta.getPrecio() ;
	}
	
	
	@Override
	public String toString() {
		return planta.getCodigo() + "\t" + cantidad + "\t"+ planta.getPrecio()+"\n";
	}
	
	

}
