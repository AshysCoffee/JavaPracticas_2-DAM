package pruebas;

public class Profesor extends Ficha{

	private int num_asignaturas;
	private boolean tutoria;
	
	
	public Profesor(String dni, String nombre, String apellidos, double salario, int num_asignaturas, boolean tutoria) {
		super(dni, nombre, apellidos, salario);
		this.num_asignaturas = num_asignaturas;
		this.tutoria = tutoria;
	}


	public int getNum_asignaturas() {
		return num_asignaturas;
	}


	public void setNum_asignaturas(int num_asignaturas) {
		this.num_asignaturas = num_asignaturas;
	}


	public boolean getTutoria() {
		return tutoria;
	}


	public void setTutoria(boolean tutoria) {
		this.tutoria = tutoria;
	}


	@Override
	public String toString() {
		return super.toString()+"\nProfesor con " + num_asignaturas + " asignaturas asignadas\nTutoria asignada: " + tutoria + "\n";
	}
	
	
	


	
	
}
