package ejercicios_acc_directo_bin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Deserializar {

	public static void main(String[] args) {
		

		try {
			ObjectInputStream ois = new ObjectInputStream (new FileInputStream("Personas.bin"));
			try {
				List<Persona> entrada = (List<Persona>) ois.readObject();
				for (Persona p : entrada) {
					System.out.println(p);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
