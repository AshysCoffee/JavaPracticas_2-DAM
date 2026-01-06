package modelosBases;

public class Stand {

	private int id_stand;
	private int id_zona;
	private String nombre;
	private String descripcion;
	
	
	
	
	public Stand(int id_stand, int id_zona, String nombre, String descripcion) {
		super();
		this.id_stand = id_stand;
		this.id_zona = id_zona;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}


	public Stand(String nombre, String descripcion, int id_zona) {
		this.id_zona = id_zona;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	

	public int getId_stand() {
		return id_stand;
	}
	public void setId_stand(int id_stand) {
		this.id_stand = id_stand;
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
		return "Stand " + id_stand + ", ID Zona=" + id_zona + ", Nombre=" + nombre + ", Descripcion="
				+ descripcion + "]";
	}
	
	
	
}
