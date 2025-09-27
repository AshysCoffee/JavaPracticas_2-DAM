package pruebas;

public class Modulo{

	private String nombre_modulo;
	private double num_horas;
	private Profesor profesor;
	private boolean convalidable;
	
	
	public Modulo(String nombre_modulo, double num_horas, Profesor profesor, boolean convalidable) {
		this.nombre_modulo = nombre_modulo;
		this.num_horas = num_horas;
		this.profesor = profesor;
		this.convalidable = convalidable;
	}


	public String getNombre_modulo() {
		return nombre_modulo;
	}


	public void setNombre_modulo(String nombre_modulo) {
		this.nombre_modulo = nombre_modulo;
	}


	public double getNum_horas() {
		return num_horas;
	}


	public void setNum_horas(double num_horas) {
		this.num_horas = num_horas;
	}


	public Profesor getProfesor() {
		return profesor;
	}


	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}


	public boolean isConvalidable() {
		return convalidable;
	}


	public void setConvalidable(boolean convalidable) {
		this.convalidable = convalidable;
	}


	@Override
	public String toString() {
		return "Modulo "+ nombre_modulo + "\nNúmero de horas: " + num_horas + "\nProfesor: " + profesor.getNombre() + " " + profesor.getApellidos() +"\nConvalidable: "
				+ convalidable + "\n\n";
	}
	
	

	
}
