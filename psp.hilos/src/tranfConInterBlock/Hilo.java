package tranfConInterBlock;

public class Hilo extends Contador implements Runnable {

	private final Contador contCompartido;

	private int contador, vueltas,miCuenta=0;
	
	public Hilo(int contador,int vueltas, Contador c) {

		this.contador = contador;
		this.vueltas= vueltas;
		this.contCompartido = c;
	}
	public int getMiCuenta() {
		return miCuenta;
	}


	public void run () {
		for(int i = 0; i<vueltas ;i++) {
			this.contCompartido.incrementar1();//incrementa el contador compartido
			this.contCompartido.incrementar2();
			miCuenta++;
		}
		System.out.println("Hilo: "+contador+" ha terminado, cuenta:"+getMiCuenta());


	} 



}
