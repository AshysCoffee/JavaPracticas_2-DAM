package practfinal_java.io;

public class Empleado {

	private String id_empleado, nombre, cargo;

	public Empleado(String id_empleado, String nombre, String cargo) {
		super();
		this.id_empleado = id_empleado;
		this.nombre = nombre;
		this.cargo = cargo;
	}

	public String getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(String id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Empleado [id_empleado=" + id_empleado + ", nombre=" + nombre + ", cargo=" + cargo + "]";
	}
	
	
	
}
