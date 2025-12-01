package modelosBases;

import java.time.LocalDate;

public class Empleado {

	private int idEmpleado;
	private String nombre;
	private Cargo cargo;
	private LocalDate fechaIngreso;
	
	public Empleado(String nombre, Cargo cargo, LocalDate fechaIngreso) {
		this.nombre = nombre;
		this.cargo = cargo;
		this.fechaIngreso = fechaIngreso;
	}
	
	
	public Empleado(int idEmpleado, String nombre, Cargo cargo, LocalDate fechaIngreso) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.cargo = cargo;
		this.fechaIngreso = fechaIngreso;
	}


	public int getIdEmpleado() {
		return idEmpleado;
	}
	
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	public String toString() {
		return "Empleado " + nombre + " con ID "+ idEmpleado+", Cargo: " + cargo + ", Fecha de Antigüedad: " + fechaIngreso ;
	}
	
}
