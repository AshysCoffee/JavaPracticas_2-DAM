package modelosBases;

public class Zona {

	private int id_zona;
	private String nombre;
	private String descripcion;
	
	public Zona(int id_zona, String nombre, String descripcion) {
		this.id_zona = id_zona;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getId_zona() {
		return id_zona;
	}

	public void setId_zona(int id_zona) {
		this.id_zona = id_zona;
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

	@Override
	public String toString() {
		return "Zona [id_zona=" + id_zona + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
}
