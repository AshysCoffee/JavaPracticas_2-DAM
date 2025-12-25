package practfinal_java_io;

import java.io.Serializable;

public class LineaDevolucion implements Serializable {
	private Planta planta;
	private int cantidad;
	private double subtotal;

	
	public LineaDevolucion(Planta planta, int cantidad) {
		this.planta = planta;
		this.cantidad = cantidad;
	}

	
	public Planta getPlanta() { 
		return planta; 
	}

	public int getCantidad() { 
		return cantidad; 
	}

	public double getSubtotal() { 
		return subtotal; 
	}


	@Override
	public String toString() {
		return planta.getNombre() + " x" + cantidad + " → -" + planta.getPrecio() * cantidad + "€";
	}
}

