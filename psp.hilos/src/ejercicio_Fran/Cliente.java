package ejercicio_Fran;

import java.util.Date;

public class Cliente {

	//ESTO ES PARA MOSTRARNOS COMO FUNCIONAN LAS COSAS STATICS
	
	private static int contador = 0; //pa toda mi gente
	
	private String nombre; //personal para el solo
	private String apellido1;
	private String apellido2;
	private String tlf;
	private String dni;
	private Date f_nac ;
	private boolean isActive;
	
	
	public static int getContador() {
		return contador;
	}
	public static void setContador(int contador) {
		Cliente.contador = contador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getTlf() {
		return tlf;
	}
	public void setTlf(String tlf) {
		this.tlf = tlf;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getF_nac() {
		return f_nac;
	}
	public void setF_nac(Date f_nac) {
		this.f_nac = f_nac;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
}
