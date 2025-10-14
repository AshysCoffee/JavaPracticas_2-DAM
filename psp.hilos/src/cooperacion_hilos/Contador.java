package cooperacion_hilos;

public class Contador {

	private int contador;

	public int getContador() {
		return contador;
	}

	
	// exclusion mutua
	// intercalarse o sobreponer entre ellos mismo
	
	public int incrementar() {
		this.contador++;
		return contador;
	}
}
