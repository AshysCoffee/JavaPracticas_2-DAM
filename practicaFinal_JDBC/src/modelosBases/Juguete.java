package modelosBases;

public class Juguete {

	private int id_juguete;
	private String nombre;
	private String descripcion;
	private double precio;
	private int cantidad_stock;
	
	public Juguete(int id_juguete, String nombre, String descripcion, double precio, int cantidad_stock) {
		this.id_juguete = id_juguete;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad_stock = cantidad_stock;
	}

	public int getId_juguete() {
		return id_juguete;
	}

	public void setId_juguete(int id_juguete) {
		this.id_juguete = id_juguete;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad_stock() {
		return cantidad_stock;
	}

	public void setCantidad_stock(int cantidad_stock) {
		this.cantidad_stock = cantidad_stock;
	}

	@Override
	public String toString() {
		return "Juguete [id_juguete=" + id_juguete + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
				+ precio + ", cantidad_stock=" + cantidad_stock + "]";
	}
	
	
	
}
