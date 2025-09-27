package pruebas;

public class Directivo extends Ficha{

	private boolean Salesiano;
	private Horario turno;
	
	
	public Directivo(String dni, String nombre, String apellidos, double salario, boolean salesiano, Horario turno) {
		super(dni, nombre, apellidos, salario);
		Salesiano = salesiano;
		this.turno = turno;
	}


	public boolean isSalesiano() {
		return Salesiano;
	}


	public void setSalesiano(boolean salesiano) {
		Salesiano = salesiano;
	}


	public Horario getTurno() {
		return turno;
	}


	public void setTurno(Horario turno) {
		this.turno = turno;
	}


	@Override
	public String toString() {
		return super.toString()+"\nDirectivo es Salesiano : " + Salesiano + " y con turno " + turno + "\n";
	}
	
	

}
