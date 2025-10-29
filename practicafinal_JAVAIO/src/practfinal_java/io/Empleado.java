package practfinal_java.io;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Empleado implements Serializable{

	private String id_empleado, nombre, contraseña, cargo;

	public Empleado(String id_empleado, String nombre, String contraseña, String cargo) {
		super();
		this.id_empleado = id_empleado;
		this.nombre = nombre;
		this.contraseña = contraseña;
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
		return "Empleado\nID = " + id_empleado + "\nNombre=" + nombre + "\nContraseña="+contraseña+"\nCargo=" + cargo + "]";
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	
}
