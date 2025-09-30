package serializar;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.util.List;

public class Deserealizar{

	public static void main(String[] args) {
	
		try (//ObjectInputStream ois = new ObjectInputStream (new FileInputStream("atletas.dat"));
		DataInputStream dis = new DataInputStream (new FileInputStream ("atletas.bin"))) {
			
			/*List<Atleta> entrada = (List<Atleta>) ois.readObject(); //hacerle un casting lol no entiendo 
			for (Atleta atleta : entrada) {
                System.out.println(atleta);
            }*/
		
		int entero = dis.readInt();
		double numero = dis.readDouble();
		boolean booleano = dis.readBoolean();
		String frase = dis.readUTF();
		
		System.out.println("Entero: "+entero+" | Double: "+numero+" | Booleano: "+booleano+" | String : "+frase);
			
		} catch (IOException e) {
			System.err.println(e);
		}/* catch (ClassNotFoundException e) {
			System.err.println(e);
		}*/
		
	}

}
