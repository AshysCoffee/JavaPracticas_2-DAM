package serializar;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Serializar implements Serializable {

	public static void main(String[] args) {

		List <Atleta> Equipo = new ArrayList <Atleta>();
		//String fichero = "atletas.dat";
		String fichero = "atletas.bin";
		File ficheroEscritura = new File (fichero);

		
		if (!ficheroEscritura.exists()){
			try {
				ficheroEscritura.createNewFile();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			if (ficheroEscritura.isFile()) {
				try {
					DataOutputStream dos = new DataOutputStream (new FileOutputStream (ficheroEscritura));//para otro tipo de datos
					try {
						//ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream (ficheroEscritura));


							/*Atleta a1 = new Atleta ("Carlos", 12,9);
							Atleta a2 = new Atleta ("Luis", 15,8);
							Atleta a3 = new Atleta ("Sofía", 11,10);
							Atleta a4 = new Atleta ("Ana", 10,7);

							Equipo.add(a1);
							Equipo.add(a2);
							Equipo.add(a3);
							Equipo.add(a4);	

							oos.writeObject(Equipo);
							oos.close();*/
						
						dos.writeInt(2);
						dos.writeDouble(5.44);
						dos.writeBoolean(false);
						dos.writeUTF("Holi uwu");
						dos.close();

					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("Archivos es directorio y no se puede hacer lol");
			}
		}




		
	}

}
