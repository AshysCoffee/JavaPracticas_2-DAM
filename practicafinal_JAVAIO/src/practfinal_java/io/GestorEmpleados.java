package practfinal_java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

//PONER UN SYSO EN LOS ERORRES PARA QUE SEA MAS VISUAL CON EL USUARIO

public class GestorEmpleados {

	public ArrayList <Empleado> empleadosAltas;
	public ArrayList <Empleado> empleadosBajas;


	public GestorEmpleados(  ) {
		super();
		this.empleadosAltas = new ArrayList <>();
		this.empleadosBajas = new ArrayList <>();
	}


//////////ESCRITURA Y LECTURA DE EMPLEADOS

	public void EscribirArchivoAlta() throws DatosInvalidosException, IOException{

		File f = new File("EMPLEADOS/empleado.dat");
		if (!f.exists()) {
		    f.getParentFile().mkdirs(); // crear carpeta si no existe
		    f.createNewFile();          // crear archivo vacío
		    System.out.println("Archivo creado porque no existía");
		}	
		
		
		try (FileOutputStream FicheroEscritura = new FileOutputStream(f);
				ObjectOutputStream escritura = new ObjectOutputStream(FicheroEscritura)) {


			Empleado empleado1 = new Empleado(6202,"Gabriela","p2s5mXw", Cargo.VENDEDOR);
			Empleado empleado2 = new Empleado(8331,"Federico","0fM123",Cargo.VENDEDOR);
			Empleado empleado3 = new Empleado(47,"Maria Jose","JkS67",Cargo.ENCARGADO);

			empleadosAltas.add(empleado1);
			empleadosAltas.add(empleado2);
			empleadosAltas.add(empleado3);

			escritura.writeObject(empleadosAltas);


			System.out.println("Objetos escritos correctamente en empleado.dat");

		} catch (IOException i) {
			i.printStackTrace();
			System.out.println ("No se ha podido escribir los objectos en el archivo empleado.dat");
		}
	} //TERMINADO --
	
	
	public ArrayList<Empleado> leerArchivoAlta() {
		
		try (FileInputStream ficherolectura = new FileInputStream("empleado.dat");
				ObjectInputStream lectura = new ObjectInputStream(ficherolectura)) {

			// Leer el ArrayList de Empleado desde el archivo
			empleadosAltas = (ArrayList<Empleado>) lectura.readObject();

			System.out.println("Objetos leídos correctamente desde empleado.dat");

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println ("No se pudieron leer los objectos desde empleado.dat");
		}

		return empleadosAltas;
	} //TERMINADO --


	public void leerEmpleadosAlta() {
		if (empleadosAltas == null || empleadosAltas.isEmpty()) {
		    System.out.println("No hay empleados para mostrar.");
		    return;
		}
		
		// Imprimir los empleados leídos
		if (empleadosAltas != null) {
			for (Empleado empleado : empleadosAltas) {
				System.out.println(empleado.toString());
			}
		}
	}  //TERMINADO --


	public ArrayList<Empleado> leerArchivoBaja() {

		try (FileInputStream ficherolectura = new FileInputStream("empleado.dat");
				ObjectInputStream lectura = new ObjectInputStream(ficherolectura)) {

			// Leer el ArrayList de Empleado desde el archivo
			empleadosBajas = (ArrayList<Empleado>) lectura.readObject();

			System.out.println("Objetos leídos correctamente desde empleado.dat");

		} catch (IOException | ClassNotFoundException e) {
           e.printStackTrace();
		   System.out.println ("Los objetos no son posibles de leer del archivo empleado.dat");
		}

		return empleadosBajas;
	} //TERMINADO --

	
	public void leerEmpleadosBaja() {
		if (empleadosBajas == null || empleadosBajas.isEmpty()) {
		    System.out.println("No hay empleados para mostrar.");
		    return;
		}
		
		// Imprimir los empleados leídos
		if (empleadosBajas != null) {
			for (Empleado empleado : empleadosBajas) {
				System.out.println(empleado.toString());
			}
		}
	}  //TERMINADO --
	
	
	public Empleado buscarEmpleadoPorIdAlta(int id) {
		for (Empleado e : empleadosAltas) {
            if (e.getId_empleado() == id) {
                return e;
            }
        }
        return null;
	} //TERMINADO --
	
	
	public Empleado buscarEmpleadoPorIdBaja(int id) {
		for (Empleado e : empleadosBajas) {
            if (e.getId_empleado() == id) {
                return e;
            }
        }
        return null;
	} //TERMINADO --
	

	
////////////VALIDACIONES DE CREDENCIALES	
	
	public Empleado validarLogin(int id, String contraseña, GestorPlantas gp) {

		for (int i=0; i<4; i++) {	
			for (Empleado e : empleadosAltas) {
				if (e.getId_empleado() == id && e.getContraseña().equals(contraseña)) {
					// Devuelve el empleado si las credenciales son correctas
					System.out.println("He iniciado sesion correctamente");
					switch (e.getCargo()) {
					case VENDEDOR:
						try {
							new MenuVendedor(e).mostrarMenu();
						} catch (DatosInvalidosException e1) {

							e1.printStackTrace();
						}
						break;
					case ENCARGADO:
						new MenuGestor(e, this, gp).mostrarMenu();
						break;
					}
					return e;
				}else{
					System.out.println("Datos erroneos, por favor intentelo de nuevo.");
				}

			}	
		}
		System.out.println("Contacte con soporte para resetear el usuario");
		return null; // Si no se encuentra coincidencia
	} //TERMINADO --



/////////////OPCIONES PARA EL GESTOR	

	public void darAltaEmpleado(int id, String nombre, String contraseña, Cargo cargo){

		Empleado e_buscado = buscarEmpleadoPorIdAlta(id);

		if (e_buscado == null) {
			System.out.println("No se encontró el empleado en activos.");

		}else if (e_buscado != null){

			empleadosAltas.add(e_buscado);

			guardarEmpleadoEnAlta(); //Lo escribimos en empleadosAltas.dat

			System.out.println("Empleado con ID " + e_buscado.getId_empleado() + " se ha dado de alta correctamente.");

			return;
		}

		System.out.println("No se encontró el empleado en activos.");
	} //PROBARLO ++

	public void guardarEmpleadoEnAlta() {

		if (empleadosAltas.isEmpty()) {
	        System.out.println("No hay empleados en alta para guardar.");
	        return;
	    }
		
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("empleados.dat"))) {

			for (Empleado e : empleadosAltas) {
				oos.writeObject(e);
			}

			System.out.println("Empleado guardado correctamente.");

		} catch (IOException e) {
			System.out.println("Error al guardar empleado: " + e.getMessage());
		}

	} //PROBARLO ++


	public void darBajaEmpleado(int id){

		Empleado e_buscado = buscarEmpleadoPorIdAlta(id);

		if (empleadosBajas.contains(e_buscado)) {
		    System.out.println("El empleado ya está dado de baja.");
		    return;
		}
		
		
		if (e_buscado == null) {
			System.out.println("No se encontró el empleado en activos.");

		}else if (e_buscado != null){

			empleadosAltas.removeIf(e -> e.getId_empleado() == e_buscado.getId_empleado());
			empleadosBajas.add(e_buscado);

			// Guardar registro del empleado dado de baja
			guardarEmpleadoEnBaja(); //Lo escribimos en empleadosBajas.dat

			System.out.println("Empleado con ID " + e_buscado.getId_empleado() + " dado de baja correctamente.");

			return;
		}

		System.out.println("No se encontró el empleado en activos.");
	} //PROBARLO ++


	public void guardarEmpleadoEnBaja() {

		if (empleadosBajas.isEmpty()) {
	        System.out.println("No hay empleados en baja para guardar.");
	        return;
	    }
		
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("BAJA/empleadosBaja.dat"))) {
			for (Empleado e : empleadosBajas) {
				oos.writeObject(e);
			}

			System.out.println("Empleado guardado correctamente.");

		} catch (IOException e) {
			System.out.println("Error al guardar empleado: " + e.getMessage());
		}

	} //PROBARLO ++


	public void recuperarEmpleado(int id) {

		Empleado e_recupera = buscarEmpleadoPorIdBaja(id);

		if (e_recupera == null) {
			System.out.println("Empleado no encontrada en bajas");
			return;
		}

		if (e_recupera != null) {
			
			empleadosBajas.removeIf(e -> e.getId_empleado() == e_recupera.getId_empleado());
			empleadosAltas.add(e_recupera);

			guardarEmpleadoEnBaja();
			guardarEmpleadoEnAlta();

			System.out.println("El empleado con "+e_recupera.getId_empleado()+" fue reactivado correctamente");

		}

	} //PROBARLO ++


}
