package pruebas;

public class Administracion  extends Ficha{

	private String estudios;
	private int antig;
	
	
	public Administracion(String dni, String nombre, String apellidos, double salario, String estudios, int antig) {
		super(dni, nombre, apellidos, salario);
		this.estudios = estudios;
		this.antig = antig;
	}


	public String getEstudios() {
		return estudios;
	}

	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}


	public int getAntig() {
		return antig;
	}


	public void setAntig(int antig) {
		this.antig = antig;
	}


	@Override
	public String toString() {
		return super.toString()+"\nAdministracion con estudios de " + estudios + " \nAntigüedad de "+ antig + " años\n";
	}
	
	
	
}
