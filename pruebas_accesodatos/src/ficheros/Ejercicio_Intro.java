package ficheros;

import java.io.*;
import java.util.Scanner;

public class Ejercicio_Intro {
	
	public static String VisualizarPermisos (File f) {

		String s="";
		
		if(f.canRead()==true) {
			s+=("r");
		}else {
			s+=("_");
		}

		if(f.canWrite()==true) {
			s+=("w");
		}else {
			s+=("_");
		}

		if(f.canExecute()==true) {
			s+=("x");
		}else {
			s+=("_");
		}
		
		return s;
	}

	public static void main(String[] args) {

		//Introducimos por consola el directorio

		/*Scanner sc = new Scanner (System.in);
		System.out.println("Indique el directorio que quiere listar:");
		String nombre_dir=sc.nextLine();

		File f = new File (nombre_dir);

		//Comprobamos que existe lol 
		//Puede haber dos casos en los cuales ninguna de las doy hay leer
		///1 - Que sea null
		///2 - Que te vacio

		if (f.isDirectory() && f.exists()) {
			File[] archivos = f.listFiles(); // obtenemos todos los archivos

			if (archivos != null) { // por seguridad, puede ser null si no tiene permisos
				for (File archivo : archivos) {
					System.out.println(archivo.getName()); // imprime solo el nombre
				}
			} else{
					System.out.println("No se pudo listar el directorio.");
			}

		}else {
			System.out.println("No existe el directorio");
		}


		sc.close();
		 */

		//---------------------------------------------------------------------

		/*
		Scanner sc = new Scanner (System.in);
		System.out.println("Indique el archivo que desea comprobar:");
		String fichero=sc.nextLine(); //se puede meter el escaner directamente en la parametro

		File f = new File (fichero);

		if (f.exists()&&f.isFile()) { //tenemos poner las do s cosas lol
			if (f.delete()){
			System.out.println("Se ha borrado con exito");
			}else{
				System.out.println("Error");
			}
		}else{
			System.out.println("No existe el archivo");
		}

		sc.close();

		 */

		//---------------------------------------------------------------------

		/*Scanner sc = new Scanner (System.in);

		System.out.println("Indique la ubicación en la que desea guardas");
		String ubi = sc.nextLine();

		File direct = new File (ubi);

		if (direct.isDirectory()==true && direct.exists()==true) {
			System.out.println("Indique el nombre a asignar del archivo");
			String fichero=sc.nextLine();
			File f = new File (ubi , fichero);
			
			try{
				if (f.createNewFile()){
					System.out.println("Se creo el fichero correspondiente");
				}else{
					System.out.println("No se creo");
				}
			}catch (IOException){
				e.getMessage();	
			}	
			
		}else{

			System.out.println("No existe el directorio");

		}

			sc.close();*/

		//---------------------------------------------------------------------		

		/*Scanner sc = new Scanner (System.in);

		System.out.println("Indique la ubicación desea listar");
		String ubi = sc.nextLine();

		File direct = new File (ubi);

		if (direct.isDirectory()==true && direct.exists()==true) {

			File[] archivos = direct.listFiles(); // obtenemos todos los archivos

	
				
				for (File archivo : archivos) {
					System.out.println(archivo.getName()); // imprime solo el nombre
					File a = new File (directorio,archivo);
					if (a.isDirectory()){
						listar (a) <-- metodo del for
						for (File archivo : archivos) {syso}  //REVISAR CODIGO EN CORRECION
					}
				}	
					
					//añadido de la profe
				if (archivos != null) //<-- he usado la recursividad sin saberlo lol XD en caso de directrorio
					
				}
			} else {
				Syso = ("Ta vacio o no lo puedo ver unu ")
			}
								//la profe queria que si era directorio recorrer todo el directorio dentro del otro y iumprimir los archivos>¿¿¿¿¿wtf ¿¿¿¿¿¿
								///recursividad??? osea lol 
		}else {
			System.out.println("No se pudo listar el directorio.");

		}

		sc.close();*/


		//---------------------------------------------------------------------				

		Scanner sc = new Scanner (System.in);
		System.out.print("Indique el archivo: ");
		String fichero=sc.nextLine();

		char opcion=' ';

		boolean resultado = true;

		File f = new File (fichero);

		if (f.exists()==false) {
			System.out.println("El archivo no existe.");
		}

		String permisos = VisualizarPermisos(f);

		if (f.exists()==true) {

			if (permisos.equals("rwx")) {
				System.out.println("Teclee el permiso a eliminar:\n- r (leer)\n- w (escritura) \n- x (ejecución)\n Si desea ver los permisos, ponga 'v' ");
				opcion = sc.next().charAt(0);

				resultado = false;
				switch (opcion) {
				case 'r':
					resultado = f.setReadable(false);
					break;
				case 'w':
					resultado = f.setWritable(false);
					break;
				case 'x':
					resultado = f.setExecutable(false);
					break;
				case 'v':
					System.out.println(VisualizarPermisos(f));
					break;
				default:
					System.out.println("Opción no válida.");
					sc.close();
					return;
				}

			}



			if (resultado==true) {
				System.out.println("Permiso eliminado correctamente.");
			} else {
				System.out.println("No se pudo modificar el permiso.");
			}

			System.out.println("Permisos ahora: " + VisualizarPermisos(f));

		}

		sc.close();


		//---------------------------------------------------------------------				


		/*Scanner sc = new Scanner (System.in);
		System.out.println("Indique el archivo que quiere crear:");
		String fichero=sc.nextLine();

		File f = new File (fichero);

		if (f.exists()==true) {
			System.out.println("El archivo existe en esta ruta: ");
			System.out.println(f.getAbsolutePath()); 
		}else {

			try {
				if (f.createNewFile()) {
					f.setWritable(false);
					System.out.println("Fichero creado en modo solo lectura: " + f.getAbsolutePath());
				} else {
					System.out.println("No se pudo crear el fichero.");
				}
			} catch (IOException e) {
				e.getMessage();
			}

		}

		sc.close();*/

	}

}
