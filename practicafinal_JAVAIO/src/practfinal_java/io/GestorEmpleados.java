package practfinal_java.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class GestorEmpleados {
	
	public static void main(String[] args) {

		ArrayList <Empleado> ListaEmpleados = new ArrayList <>();

		try (FileOutputStream FicheroEscritura = new FileOutputStream("empleados.dat");
				
				ObjectOutputStream escritura = new ObjectOutputStream(FicheroEscritura)) {


			Empleado empleado1 = new Empleado(1452,"Teresa","asb123","vendedor");
			Empleado empleado2 = new Empleado(0234,"Miguel Angel","123qwe","vendedor");
			Empleado empleado3 = new Empleado(7532,"Natalia","xs21qw4","gestor");

			ListaEmpleados.add(empleado1);
			ListaEmpleados.add(empleado2);
			ListaEmpleados.add(empleado3);

			escritura.writeObject(ListaEmpleados);


			System.out.println("Objetos escritos correctamente en empleado.dat");

		} catch (IOException i) {
			i.printStackTrace();
		}


	}
}
