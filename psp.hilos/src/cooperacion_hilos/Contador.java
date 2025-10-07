package cooperacion_hilos;

public class Contador {

	private int contador;

	public int getContador() {
		return contador;
	}

	public int incrementar() {
		this.contador++;
		return contador;
	}
}
