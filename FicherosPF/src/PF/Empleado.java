package PF;
import java.io.Serializable;

public class Empleado implements Serializable{
	 private int identificacion;
	 private String nombre;
	 private String password;
	 private String cargo;	 
	
	public Empleado(int identificacion, String nombre, String password, String cargo) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.password = password;
		this.cargo = cargo;
	}
	public int getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	@Override
	public String toString() {
		return "Empleado [identificacion=" + identificacion + ", nombre=" + nombre + ", password=" + password
				+ ", cargo=" + cargo + "]";
	}
	
	
	 
	}

