package biblioteca;

public class Revista extends Base{

	private int numero;

	public Revista(String titulo, String iSBN, String fecha_edicion, int numero) {
		super(titulo, iSBN, fecha_edicion);
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String toString() {
		return ("-----> REVISTA: \n")+super.toString()+"Número: "+numero;
	}
	
	
}
