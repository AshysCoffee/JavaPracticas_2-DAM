package biblioteca;

public class Libro extends Base implements Prestable{

	private boolean prestado;

	public Libro(String titulo, String iSBN, String fecha_edicion) {
		super(titulo, iSBN, fecha_edicion);
		prestado = false;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}


	public void prestar() {
		prestado = true;
	}


	public void devolver() {
		prestado = false;
	}


	public boolean prestado() {
		return prestado;

	}
	
	public String toString() {
		return 	("-----> LIBRO: \n")+super.toString()+"Prestado: "+prestado;
	}
	
}
