package gestionRespuestas;

public class Hilo extends ResultadosEncuestas implements Runnable {

	private int numHilos, vueltas = 0;
	private final ResultadosEncuestas cont; //nadie lo puede cambiar

	
	public Hilo(int numHilos, int vueltas, ResultadosEncuestas cont) {
		super();
		this.numHilos = numHilos;
		this.vueltas = vueltas;
		this.cont = cont;
	}
	
	
	@Override
	public void run() {
		for (int i = 0; i<vueltas; i++) {
			this.cont.votosTotales();// incrementa el contador compartido el de todos
			this.cont.votosPorZona(numHilos);
			int votos = (int)(Math.random()*3); //0 = NS/NC , 1= Si, 2= No
			switch(votos) {
			case 0:
				
				cont.votosTotales();
				cont.votosNsNc(votos);
				break;
			case 1:
				cont.votosTotales();
				cont.votosSi(votos);
				break;
			case 2:
				cont.votosTotales();
				cont.votosNo(votos);
				break;

			}
		}
		
		System.out.printf("Zona %d terminado, cuenta total por zona : %d\n"
				+ "Con %d votos a favor, %d votos en contra , %d votos vacios\n\n"
				, numHilos, cont.getContadorPerZona(), cont.getContSi(),cont.getContNo(),cont.getContNsNc());

		
	}
	
	
	
}
