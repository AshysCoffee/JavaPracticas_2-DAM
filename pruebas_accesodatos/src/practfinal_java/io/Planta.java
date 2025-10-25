package practfinal_java.io;

public class Planta {
	
	private String nombre, foto, descripcion;
	private int codigo, cantidad;
	private float precio;


	Planta(int codigo, String nombre, String foto, String descripcion) {
		super();
		this.nombre = nombre;
		this.foto = foto;
		this.descripcion = descripcion;
		this.codigo = codigo;
		this.cantidad = 0;
		this.precio = 0;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Planta " + nombre + "\nFoto: " + foto + "\nDescripcion: " + descripcion + "\nCodigo: " + codigo
				+ "\nCantidad: " + cantidad + "\nPrecio:" + precio +"\n\n";
	}
	
	

}
