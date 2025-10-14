package gestionRespuestas;

public class ResultadosEncuestas {

	private int contador, contadorPerZona=0, contSi, contNo, contNsNc;

	 public synchronized int getContador() {
		return contador;
	}

	public int getContadorPerZona() {
		return contadorPerZona;
	}


	public synchronized int getContSi() {
		return contSi;
	}

	public synchronized int getContNo() {
		return contNo;
	}


	public synchronized int getContNsNc() {
		return contNsNc;
	}

	
	//---------------------------

	synchronized public int votosTotales() {
		this.contador++;
		return contador;
	}
	
	public int votosPorZona (int id_zona) {
		this.contadorPerZona++;
		return contadorPerZona;
	}

	
	synchronized public int votosSi (int id_r) {
		this.contSi++;
		return contSi;
	}
	
	synchronized public int votosNo (int id_r) {
		this.contNo++;
		return contNo;
	}
	
	synchronized public int votosNsNc (int id_r) {
		this.contNsNc++;
		return contNsNc;
	}
	
}
