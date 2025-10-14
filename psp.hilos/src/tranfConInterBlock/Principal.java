package tranfConInterBlock;

public class Principal {

	public static void main(String[] args) {
		
		Cuenta c1 = new Cuenta (199054,"ES111222333");
		Cuenta c2 = new Cuenta (250000,"ES444555666");
		
		System.out.printf("Saldo final de %s %d/n",c1.getCuenta_banc(), c1.getSaldo());
		System.out.printf("Saldo final de %s %d/n",c2.getCuenta_banc(), c2.getSaldo());
		System.out.println("---------------------------");
		
		
		/*Thread h1 = new Thread (new Hilo (c1,c2,"H1"));
		Thread h2 = new Thread (new Hilo (c2,c1,"H2"));

		h1.start();
		h2.start();
		
		
		try {
		h1.join();
		h2.join();
		
		}catch (InterruptedException e){
			e.printStackTrace();
		}*/
	}
	
}
