package pruebas;

import java.util.ArrayList;

public class Alumno{
	
	private String dni;
	private String nombre_alumno;
	private String apellidos;
	private String fecha;
	private Sexo genero;
	private boolean repetidor;
	ArrayList <Modulo> modulos;
	
	
	
	public Alumno(String dni, String nombre_alumno, String apellidos, String fecha, Sexo genero, boolean repetidor) {

		this.dni = dni;
		this.nombre_alumno = nombre_alumno;
		this.apellidos = apellidos;
		this.fecha=fecha;
		this.genero = genero;
		this.repetidor = repetidor;
		modulos = new ArrayList <Modulo>();
	}
	
	public void CrearAlumno(String dni, String nombre_alumno, String apellidos, String fecha, char genero, char repetidor) {
		this.dni = dni;
		this.nombre_alumno = nombre_alumno;
		this.apellidos = apellidos;
		this.fecha=fecha;
		
		char respuesta_letra = ' ';
		if (respuesta_letra == 'F'||respuesta_letra != 'f') {
		this.genero = Sexo.FEMENINO;
		}else if (respuesta_letra == 'M' || respuesta_letra == 'm'){
			this.genero = Sexo.MASCULINO;
		}
		
		if (respuesta_letra == 'S'||respuesta_letra != 's') {
		this.repetidor = true;
		}else if (respuesta_letra == 'N'||respuesta_letra != 'n'){
			this.repetidor = false;
		}else if (respuesta_letra != 'N' && respuesta_letra != 'S') {
			System.out.println("No es válida su eleccion");
		}
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombre_alumno() {
		return nombre_alumno;
	}


	public void setNombre_alumno(String nombre_alumno) {
		this.nombre_alumno = nombre_alumno;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public Sexo getGenero() {
		return genero;
	}


	public void setGenero(Sexo genero) {
		this.genero = genero;
	}


	public boolean isRepetidor() {
		return repetidor;
	}


	public void setRepetidor(boolean repetidor) {
		this.repetidor = repetidor;
	}

	
	public void ModuloAdd (Modulo m) {
		modulos.add(m);
	}
	
	public void ModuloDelete(Modulo m) {
		modulos.remove(m);
	}

	public ArrayList<Modulo> getModulos() {
		return modulos;
	}


	public void setModulos(ArrayList<Modulo> modulos) {
		this.modulos = modulos;
	}

	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	@Override
	public String toString() {
		return "Alumno " +nombre_alumno+" "+ apellidos+ "\nDNI = " + dni + "\nFecha de nacimiento = "
				+ fecha + "\nGénero = " + genero + "\nRepetidor = " + repetidor+"\n\n";
	}



}
