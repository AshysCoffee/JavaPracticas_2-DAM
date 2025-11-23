package practfinal_java_io;

import java.io.Serializable;
import java.util.regex.*;
import java.util.ArrayList;

		//COMENTAR TODO POR FAVOR ;

@SuppressWarnings("serial")
public class Empleado implements Serializable{
	
	private String nombre, contraseña;
	private Cargo cargo;
	private int id_empleado;
	
	private static ArrayList <Integer> idUsados = new ArrayList <>();

	public Empleado(int id_empleado, String nombre, String contraseña, Cargo cargo) throws DatosInvalidosException {
		
        this.id_empleado = id_empleado;
        
        if (idUsados.contains(id_empleado)) {
            throw new DatosInvalidosException("El ID ya existe.");
        }
        idUsados.add(id_empleado);
        
        this.nombre = nombre;
		this.contraseña = contraseña;
		this.cargo = cargo;
		
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
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

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	//----- METODOS DE COMPROBACION
	
	
	public boolean validarId (int id) {
		
	    return !idUsados.contains(id); //Esto devuelve true solo si el ID no está repetido.
	}
	
	public boolean validarContraseña(String pwd) {
		
		Pattern patron = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{5,7}$");
		Matcher matcher = patron.matcher(pwd);
		
		if (matcher.matches()) {  // igual que String.matches()
		    return true;
		}
		
		return false;
	}
	
	
	
	@Override
	public String toString() {

		return String.format("Empleado\nID = %04d \nNombre = %s\nCargo = %s\n", id_empleado, nombre, cargo);
		
	}

}
