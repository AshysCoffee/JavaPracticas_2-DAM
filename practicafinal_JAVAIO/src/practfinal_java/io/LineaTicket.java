package practfinal_java.io;

import java.io.Serializable;

public class LineaTicket implements Serializable{
	
	private int codigoProducto, unidades, precio_unidad;
	
	public LineaTicket(int codigoProducto, int unidades, int precio_unidad) {
		super();
		this.codigoProducto = codigoProducto;
		this.unidades = unidades;
		this.precio_unidad = precio_unidad;
	}

	
	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public int getPrecio_Unidad() {
		return precio_unidad;
	}

	public void setPrecio_Precio(int precio_unidad) {
		this.precio_unidad = precio_unidad;
	}
	
	 public float calcularSubtotal() {
	        return unidades * precio_unidad ;
	    }

	
	
	@Override
	public String toString() {
		return codigoProducto + "\t" + unidades + "\t"+ precio_unidad+"\n";
	}
	
	

}
